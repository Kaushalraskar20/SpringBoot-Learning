package com.xpert;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.mail.MessagingException;

@Controller
public class MailController {

    private final EmailService emailService;

    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendMail")
    public String sendMail(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("name") String name,
            @RequestParam("message") String message,
            RedirectAttributes redirectAttributes) {

        try {
            Map<String, Object> variables = new HashMap<>();

            variables.put("subject", subject);
            variables.put("name", name);
            variables.put("message", message);

            emailService.sendEmail(
                    to, subject, "emailTemplate", variables);

            redirectAttributes.addAttribute("status", "success");
            redirectAttributes.addAttribute("to", to);

            return "redirect:/EmailFormServlet";

        } catch (MessagingException | RuntimeException e) {
            e.printStackTrace();

            redirectAttributes.addAttribute("status", "error");

            return "redirect:/EmailFormServlet";
        }
    }
}