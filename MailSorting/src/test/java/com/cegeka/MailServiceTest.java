package com.cegeka;

import com.cegeka.repository.*;
import com.cegeka.service.MailService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.refEq;

public class MailServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private MailService mailService;

    @Mock
    private RecruitmentRepository recruitmentRepository;

    @Mock
    private SalesRepository salesRepository;

    @Before
    public void setUp() throws Exception {
        Map<String, IRepository> repositoryMap = new HashMap<>();
        repositoryMap.put("cv", recruitmentRepository);
        repositoryMap.put("proposal", salesRepository);
        ReflectionTestUtils.setField(mailService, "repositoryMap", repositoryMap);
    }

    @Test
    public void ReturnAllMailsCV(){
        mailService.getAllRecruitmentMails();
        Mockito.verify(recruitmentRepository).getAllMails();
    }

    @Test
    public void SortMailsCV_ShouldSendToCVRepo(){
        mailService.sortMail("CV");
        Mockito.verify(recruitmentRepository).addMail(refEq(new Mail("CV")));
    }

    @Test
    public void SortMailsSales_ShouldSendToSalesRepo(){
        mailService.sortMail("proposal");
        Mockito.verify(salesRepository).addMail(refEq(new Mail("proposal")));
    }

    @Test
    public void SortMailsV2CV_ShouldSendToCVRepo(){
        mailService.sortMailV2("CV");
        Mockito.verify(recruitmentRepository).addMail(refEq(new Mail("CV")));
    }

    @Test
    public void SortMailsV2Sales_ShouldSendToSalesRepo(){
        mailService.sortMailV2("proposal");
        Mockito.verify(salesRepository).addMail(refEq(new Mail("proposal")));
    }
}
