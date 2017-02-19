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
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
        return convertFromMailsToSubjects(mailService.getAllReceptionMails());
    }

    @RequestMapping(value = "/recruitment", method = RequestMethod.GET)
    @ResponseBody
    List<String> recruitmentMails() {
        return convertFromMailsToSubjects(mailService.getAllRecruitmentMails());
    }

    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    @ResponseBody
    List<String> salesMails() {
        return convertFromMailsToSubjects(mailService.getAllSalesMails());
    }

    @RequestMapping(value = "/spam", method = RequestMethod.GET)
    @ResponseBody
    List<String> spamMails() {
        return convertFromMailsToSubjects(mailService.getAllSpamMails());
    }

    private List<String> convertFromMailsToSubjects(List<Mail> mails) {
        return mails.stream()
                .map(mail -> mail.toSubject())
                .collect(toList());
    }
}
