package com.unstoppable.myblog.service;

import com.unstoppable.myblog.entity.Task;
import com.unstoppable.myblog.entity.User;
import com.unstoppable.myblog.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user) {
        return taskRepository.findByUser(user);
    }

}
