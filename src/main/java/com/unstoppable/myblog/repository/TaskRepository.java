package com.unstoppable.myblog.repository;

import com.unstoppable.myblog.entity.Task;
import com.unstoppable.myblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

}
