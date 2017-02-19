package com.cegeka.repository;

import com.cegeka.Mail;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ReceptionRepository implements IRepository {
    List<Mail> mailsReception = new ArrayList<>();

    @Override
    public void addMail(Mail mail) {
        mailsReception.add(mail);
    }

    @Override
    public List<Mail> getAllMails() {
        return new ArrayList<>(mailsReception);
    }
}
