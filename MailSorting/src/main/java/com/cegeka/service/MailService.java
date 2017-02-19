package com.cegeka.service;

import com.cegeka.Mail;
import com.cegeka.repository.ReceptionRepository;
import com.cegeka.repository.RecruitmentRepository;
import com.cegeka.repository.SalesRepository;
import com.cegeka.repository.SpamRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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
