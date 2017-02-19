package com.cegeka.service;

import com.cegeka.Mail;
import com.cegeka.repository.*;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class MailService {
    @Inject
    private RecruitmentRepository recruitmentRepository;

    @Inject
    private SalesRepository salesRepository;

    @Inject
    private SpamRepository spamRepository;

    @Inject
    private ReceptionRepository receptionRepository;

    @Value("#{{'cv':@recruitmentRepository," +
            "'proposal':@salesRepository," +
            "'promotion':@spamRepository," +
            "'coupon':@spamRepository," +
            "'default':@receptionRepository}}")
    private Map<String, IRepository> repositoryMap;

    public void sortMail(String subject) {
        if (subject.toLowerCase().equals("cv")) {
            recruitmentRepository.addMail(new Mail(subject));
        } else if (subject.toLowerCase().equals("promotion") || subject.toLowerCase().equals("coupon")) {
            spamRepository.addMail(new Mail(subject));
        } else if (subject.toLowerCase().equals("proposal")) {
            salesRepository.addMail(new Mail(subject));
        } else {
            receptionRepository.addMail(new Mail(subject));
        }
    }

    public void sortMailV2(String subject) {
        repositoryMap.getOrDefault(subject.toLowerCase(), receptionRepository).addMail(new Mail(subject));
    }

    public List<Mail> getAllRecruitmentMails() {
        return recruitmentRepository.getAllMails();
    }

    public List<Mail> getAllReceptionMails() {
        return receptionRepository.getAllMails();
    }

    public List<Mail> getAllSalesMails() {
        return salesRepository.getAllMails();
    }

    public List<Mail> getAllSpamMails() {
        return spamRepository.getAllMails();
    }
}
