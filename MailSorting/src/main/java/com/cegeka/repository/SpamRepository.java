package com.cegeka.repository;

import com.cegeka.Mail;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class SpamRepository implements IRepository{
    List<Mail> mailsSpam = new ArrayList<>();

    public void addMail(Mail mail) {
        mailsSpam.add(mail);
    }

    @Override
    public List<Mail> getAllMails() {
        return new ArrayList<>(mailsSpam);
    }
}
