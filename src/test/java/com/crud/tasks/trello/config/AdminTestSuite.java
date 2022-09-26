package com.crud.tasks.trello.config;

import com.crud.tasks.config.AdminConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminTestSuite {

    @Autowired
    private AdminConfig adminConfig;

    @Test
    void getAdminTest(){
        //Given
        //When
        String adminMail = adminConfig.getAdminMail();
        //Then
        assertEquals("jakubmihulka02@gmail.com", adminMail);
    }
}
