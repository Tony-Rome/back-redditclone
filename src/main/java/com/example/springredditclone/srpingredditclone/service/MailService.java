package com.example.springredditclone.srpingredditclone.service;

import com.example.springredditclone.srpingredditclone.exceptions.SpringRedditException;
import com.example.springredditclone.srpingredditclone.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author tony
 */
@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    
    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;
    
    @Async
    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("springreddit@email.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };
        try{
            mailSender.send(messagePreparator);
            log.info("Se envió activación de email");
        } catch(MailException e){
            throw new SpringRedditException("Ha ocurrido una excepción al enviar confirmación de email");
        }
    }
    
}
