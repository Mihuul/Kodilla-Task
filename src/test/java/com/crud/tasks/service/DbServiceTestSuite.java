package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@Transactional
@ActiveProfiles("test")
@SpringBootTest
public class DbServiceTestSuite {

    @Autowired
    private DbService dbService;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testSaveTask(){
        //Given
        Task task = new Task(1L, "Test1", "test");
        //When
        dbService.saveTask(task);
        //Then
        assertEquals(1, taskRepository.findAll().size());
    }

    @Test
    public void testGetAllTasks(){
        //Given
        Task task = new Task(1L, "Test1", "test");
        Task task2 = new Task(2L, "Test2", "test2");
        taskRepository.save(task);
        taskRepository.save(task2);
        //When
        List<Task> taskList = dbService.getAllTasks();
        //Then
        assertEquals(2, taskList.size());
        taskRepository.deleteAll();
    }

    @Test
    public void testGetTask() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "Test1", "test");
        taskRepository.save(task);
        Long id = task.getId();
        //When
        Task foundTask = dbService.getTask(id);
        //Then
        assertEquals("Test1", foundTask.getTitle());
        assertEquals("test", foundTask.getContent());
        taskRepository.deleteAll();
    }

    @Test
    public void testDeleteTask(){
        //Given
        Task task = new Task(1L, "Test1", "test");
        Task task2 = new Task(2L, "Test2", "test2");
        taskRepository.save(task);
        taskRepository.save(task2);
        Long id = task.getId();
        //When
        dbService.deleteTask(id);
        //Then
        assertEquals(1, taskRepository.findAll().size());
        taskRepository.deleteAll();
    }
}