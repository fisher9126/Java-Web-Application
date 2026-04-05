package re.edu.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final EmailSender emailSender;
    private final SmsSender smsSender;

    public NotificationService(EmailSender emailSender, SmsSender smsSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }

    public String send(String msg) {
        emailSender.send(msg);

        try {
            smsSender.send(msg);
        } catch (Exception e) {
            return "Email OK, SMS lỗi";
        }

        return "Gửi thành công cả Email và SMS";
    }
}
