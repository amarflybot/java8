package amar.rx.EventDrivenPattern;

import java.util.List;

/**
 * Created by amarendra on 22/10/16.
 */
public interface EmailService {
    void sendEmail(List<String> recipients, String from, String subject, String text);
}
