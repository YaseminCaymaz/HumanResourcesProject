package org.example.controller;

import org.example.dto.Request.ResetEmailRequest;
import org.example.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final MailSenderService mailService;

    @Autowired
    public MailController(MailSenderService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send-reset-email")
    public String sendResetEmail(@RequestBody ResetEmailRequest request) {
        String recipientEmail = request.getEmail();
        String resetToken = "A43875";
        mailService.sendPasswordResetEmail(recipientEmail, resetToken);
        return "Parola sıfırlama e-postası gönderildi.";
    }//Sabit token kullandım. İstenilirse token oluşturulabilir.
}