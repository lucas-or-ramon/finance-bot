package br.com.devcanoa.financebot;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class ReceiveMessage {

    public static final String FINANCE_API = System.getenv("FINANCE_API");

    @PostMapping(value = "/receive", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> receive() {

        var response = new RestTemplate().getForEntity(FINANCE_API + "/resume/monthly/2022/08", String.class).getBody();

        var body = new Body.Builder(response).build();
        var message = new Message.Builder().body(body).build();
        var messagingResponse = new MessagingResponse.Builder().message(message).build();

        return ResponseEntity.ok(messagingResponse.toXml());
    }
}