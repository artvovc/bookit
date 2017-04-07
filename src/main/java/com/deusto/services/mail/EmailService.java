package com.deusto.services.mail;

import com.deusto.builders.mail.Email;
import com.deusto.forms.email.EmailField;
import com.deusto.services.template.FreeMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerService markerService;

    @Autowired
    private Environment env;

    public <T extends EmailField> void send(String htmlTemplate, T reg) throws Exception {
        Email email = Email.builder()
                .from(env.getProperty("spring.mail.username"))
                .to(reg.getEmail())
                .subject(env.getProperty("mail.subject"))
                .text(markerService.html(htmlTemplate, reg))
                .build();
        mailSender.send(email.messagePreparator());
    }

}
