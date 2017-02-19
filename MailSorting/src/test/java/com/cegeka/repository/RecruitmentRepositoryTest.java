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
public class RecruitmentRepositoryTest {
    private RecruitmentRepository recruitmentRepository;
    List<Mail> expected = new ArrayList<>();
    Mail cv;
    Mail cv2;
    Mail cv3;

    @Before
    public void setUp(){
        recruitmentRepository = new RecruitmentRepository();

        cv = new Mail("CV");
        cv2 = new Mail("CV");
        cv3 = new Mail("CV");

        expected.add(cv);
        expected.add(cv2);
        expected.add(cv3);
    }


    @Test
    public void getAllMails() throws Exception {
        recruitmentRepository.addMail(cv);
        recruitmentRepository.addMail(cv2);
        recruitmentRepository.addMail(cv3);
        Assertions.assertThat(recruitmentRepository.getAllMails()).isEqualTo(expected);
    }
}