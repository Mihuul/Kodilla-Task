package com.crud.tasks.trello.config;

import com.crud.tasks.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    void getFullHttpRequestTest(){
        //Given
        String url = "https://api.trello.com/188d280876749612175969a761a5726201f8eb303e7caced6f57603ca8e1f67a3ef2e053bedc54f349e6e1f122e1645c0jakubmihulka02";
        //When
        String apiEndpoint = trelloConfig.getTrelloApiEndpoint();
        String appKey = trelloConfig.getTrelloAppKey();
        String token = trelloConfig.getTrelloToken();
        String username = trelloConfig.getTrelloUsername();
        String result = apiEndpoint + appKey + token + username;
        //Then
        assertEquals(url, result);
    }
}
