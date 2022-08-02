package br.com.devcanoa.financebot;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SendMessage {

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    @GetMapping("/send")
    public ResponseEntity<String> send() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        var message = Message.creator(
                        new PhoneNumber("whatsapp:+559192933831"),
                        new PhoneNumber("whatsapp:+14155238886"),
                        "Consegui Enviar a Mensagem!!")
                .create();

        return ResponseEntity.ok(message.getSid());
    }
}
