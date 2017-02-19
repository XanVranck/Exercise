package com.cegeka.repository;

import com.cegeka.Mail;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class RecruitmentRepository implements IRepository {
    private List<Mail> mailsRecruitment = new ArrayList<>();

    @Override
    public void addMail(Mail mail) {
        mailsRecruitment.add(mail);
    }

    @Override
    public List<Mail> getAllMails() {
        return new ArrayList<>(mailsRecruitment);
    }
}