package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ValidatorTestSuite {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    void validateTrelloBoards(){
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("1", "test", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "kodilla", new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        trelloBoards.add(trelloBoard2);
        //When
        List<TrelloBoard> filteredList = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertEquals(1, filteredList.size());
        assertEquals(0,filteredList.get(0).getLists().size());
        assertEquals("2", filteredList.get(0).getId());
        assertEquals("kodilla", filteredList.get(0).getName());
    }
}
