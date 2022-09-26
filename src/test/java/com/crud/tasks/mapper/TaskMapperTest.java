package com.crud.tasks.mapper;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.dto.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void mapToTaskTest(){
        //Given
        TaskDto taskDto = new TaskDto(1L,"Test", "test1");
        //When
        Task result = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1L, result.getId());
        assertEquals("Test", result.getTitle());
        assertEquals("test1", result.getContent());
    }

    @Test
    void mapToTaskDtoTest(){
        //Given
        Task task = new Task(1L, "Test", "test1");
        //When
        TaskDto result = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1L, result.getId());
        assertEquals("Test", result.getTitle());
        assertEquals("test1", result.getContent());
    }

    @Test
    void mapToTaskDtoListTest(){
        //Given
        Task task = new Task(1L, "Test", "test1");
        Task task2 = new Task(2L, "Test2", "test2");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        tasks.add(task2);
        //When
        List<TaskDto> result = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(2,result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Test", result.get(0).getTitle());
        assertEquals("test1", result.get(0).getContent());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Test2", result.get(1).getTitle());
        assertEquals("test2", result.get(1).getContent());
    }

}
