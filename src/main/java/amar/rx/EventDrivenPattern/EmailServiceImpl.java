package amar.rx.EventDrivenPattern;

import java.util.List;

/**
 * Created by amarendra on 22/10/16.
 */
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(List<String> recipients, String from, String subject, String text){
        System.out.println("Sending Email");
        System.out.println("TO: ");

        recipients.stream().forEach(recipient -> {
            System.out.print(recipient);
            System.out.print(";");
            System.out.println("");
        });

        System.out.println("From: "+ from);
        System.out.println("Subject: "+ subject);
        System.out.println();
        System.out.println("Text: "+ text);
        System.out.println();
    }
}
