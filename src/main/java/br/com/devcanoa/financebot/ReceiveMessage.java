package br.com.devcanoa.financebot;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@RestController
@RequestMapping
public class ReceiveMessage {

    public static final String FINANCE_API = System.getenv("FINANCE_API");

    @PostMapping(value = "/receive", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> receive(@RequestBody String request) throws IOException {

//        var response = new RestTemplate().getForEntity(FINANCE_API + "/resume/annual/2022/08", AnnualResume.class).getBody();
        var properties = new Properties();
        properties.load(IOUtils.toInputStream(request, StandardCharsets.UTF_8));

        var whatsappRequest = new WhatsappRequest(properties.getProperty("Body"), properties.getProperty("From"), properties.getProperty("ProfileName"));

        var body = new Body.Builder(whatsappRequest.toString()).build();
        var message = new Message.Builder().body(body).build();
        var messagingResponse = new MessagingResponse.Builder().message(message).build();

        return ResponseEntity.ok(messagingResponse.toXml());
    }
}
