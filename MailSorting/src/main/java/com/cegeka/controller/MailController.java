package com.cegeka.controller;

import com.cegeka.Mail;
import com.cegeka.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Inject
    private MailService mailService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    void addMail(
            @RequestParam(value = "subject") String subject) {
        mailService.sortMail(subject);
    }

    @RequestMapping(value = "/reception", method = RequestMethod.GET)
    @ResponseBody
    List<String> receptionMails() {
        List<String> subject = new ArrayList<>();
        for (Mail mail : mailService.getAllReceptioonMails()) {
            subject.add(mail.toString());
        }
        return subject;
    }

    @RequestMapping(value = "/recruitment", method = RequestMethod.GET)
    @ResponseBody
    List<String> recruitmentMails() {
        List<String> subject = new ArrayList<>();
        for (Mail mail : mailService.getAllRecruitmentMails()) {
            subject.add(mail.toString());
        }
        return subject;
    }

    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    @ResponseBody
    List<String> salesMails() {
        List<String> subject = new ArrayList<>();
        for (Mail mail : mailService.getAllSalesMails()) {
            subject.add(mail.toString());
        }
        return subject;    }

    @RequestMapping(value = "/spam", method = RequestMethod.GET)
    @ResponseBody
    List<String> spamMails() {
        List<String> subject = new ArrayList<>();
        for (Mail mail : mailService.getAllSpamMails()) {
            subject.add(mail.toString());
        }
        return subject;    }
}
