package com.cegeka.repository;

import com.cegeka.Mail;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class SalesRepository implements IRepository{
    List<Mail> mailsSales = new ArrayList<>();

    public void addMail(Mail mail) {
        mailsSales.add(mail);
    }

    @Override
    public List<Mail> getAllMails() {
        return new ArrayList<>(mailsSales);
    }
}
