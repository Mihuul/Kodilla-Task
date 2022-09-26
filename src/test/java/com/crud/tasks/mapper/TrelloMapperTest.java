package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.dto.TrelloBoardDto;
import com.crud.tasks.domain.dto.TrelloCardDto;
import com.crud.tasks.domain.dto.TrelloListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards(){
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "board1", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        //When
        List<TrelloBoard> trelloBoardsList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals(1, trelloBoardsList.size());
        assertEquals("1", trelloBoardsList.get(0).getId());
        assertEquals("board1", trelloBoardsList.get(0).getName());
        assertEquals(0, trelloBoardsList.get(0).getLists().size());
    }

    @Test
    public void testMapToBoardDto() {
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("1", "board1", new ArrayList<>());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardDto(trelloBoardList);
        //Then
        assertEquals(1, trelloBoardDtoList.size());
        assertEquals("1",trelloBoardDtoList.get(0).getId());
        assertEquals("board1", trelloBoardDtoList.get(0).getName());
        assertEquals(0, trelloBoardDtoList.get(0).getLists().size());
    }

    @Test
    public void testMapToList(){
        TrelloListDto trelloListDto = new TrelloListDto("1", "List1", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);
        //Then
        assertEquals(1, trelloLists.size());
        assertEquals("1", trelloLists.get(0).getId());
        assertEquals("List1", trelloLists.get(0).getName());
        assertTrue(trelloLists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto(){
        //Given
        TrelloList trelloList = new TrelloList("1", "List1", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        //Then
        assertEquals(1, trelloListDtos.size());
        assertEquals("1", trelloListDtos.get(0).getId());
        assertEquals("List1", trelloListDtos.get(0).getName());
        assertTrue(trelloListDtos.get(0).isClosed());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card", "theCard","Up", "1");
        //When
        TrelloCard trelloCard = trelloMapper.mapToTrelloCard(trelloCardDto);
        //Then
        assertEquals("card", trelloCard.getName());
        assertEquals("theCard", trelloCard.getDescription());
        assertEquals("Up", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }

    @Test
    public void testMapToTrelloCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card", "theCard","Up", "1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("card", trelloCardDto.getName());
        assertEquals("theCard", trelloCardDto.getDescription());
        assertEquals("Up", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }

}
