package com.cegeka.repository;

import com.cegeka.Mail;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xanv on 19/02/2017.
 */
public class ReceptionRepositoryTest {
    private ReceptionRepository receptionRepository;
    List<Mail> expected = new ArrayList<>();
    Mail blah;
    Mail bla;
    Mail bl;

    @Before
    public void setUp(){
        receptionRepository = new ReceptionRepository();

        blah = new Mail("blah");
        bla = new Mail("bla");
        bl = new Mail("bl");

        expected.add(blah);
        expected.add(bla);
        expected.add(bl);
    }


    @Test
    public void getAllMails() throws Exception {
        receptionRepository.addMail(blah);
        receptionRepository.addMail(bla);
        receptionRepository.addMail(bl);
        Assertions.assertThat(receptionRepository.getAllMails()).isEqualTo(expected);
    }

}