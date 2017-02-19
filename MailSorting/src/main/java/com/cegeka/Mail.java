package com.cegeka;

/**
 * Created by xanv on 19/02/2017.
 */
public class Mail {
    private String subject;

    public Mail(String subject) {
        this.subject = subject;
    }

    public String toSubject(){
        return "subject: " + subject;
    }

    public String toString(){
        return "subject: " + subject;
    }
}
