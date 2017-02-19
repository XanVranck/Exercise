package com.cegeka.repository;

import com.cegeka.Mail;

import java.util.List;

/**
 * Created by xanv on 19/02/2017.
 */
public interface IRepository {
    void addMail(Mail mail);
    List<Mail> getAllMails();
}
