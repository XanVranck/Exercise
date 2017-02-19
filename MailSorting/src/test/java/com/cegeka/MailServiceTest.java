package com.cegeka;

import com.cegeka.repository.*;
import com.cegeka.service.MailService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MailServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private MailService mailService;

    @Mock
    private RecruitmentRepository recruitmentRepository;

    @Mock
    private SalesRepository salesRepository;

    @Test
    public void ReturnAllMailsCV(){
        mailService.getAllRecruitmentMails();
        Mockito.verify(recruitmentRepository).getAllMails();
    }

    @Test
    public void SortMailsCV_ShouldSendToCVRepo(){
        mailService.sortMail("CV");
        Mockito.verify(recruitmentRepository).addMail(new Mail("CV"));
    }

    @Test
    public void SortMailsSales_ShouldSendToSalesRepo(){
        mailService.sortMail("sales");
        Mockito.verify(salesRepository).addMail(new Mail("sales"));
    }
}
