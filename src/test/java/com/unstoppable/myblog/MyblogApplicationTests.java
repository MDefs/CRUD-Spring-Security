package com.unstoppable.myblog;

import com.unstoppable.myblog.entity.Task;
import com.unstoppable.myblog.entity.User;
import com.unstoppable.myblog.service.TaskService;
import com.unstoppable.myblog.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyblogApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initDb() {
        {
            User newUser = new User("testuser@mail.com", "testUser", "12345");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testadmin@mail.com", "testAdmin", "12345");
            userService.createAdmin(newUser);
        }

        Task userTask = new Task("03/01/2018", "00:11", "11:00", "You need to work today");
        User user = userService.findOne("testuser@mail.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testUser() {
        User user = userService.findOne("testuser@mail.com");
        Assert.assertNotNull(user);
        User admin = userService.findOne("testadmin@mail.com");
        Assert.assertEquals(admin.getEmail(), "testadmin@mail.com");
    }

    @Test
    public void testTask() {
        User user = userService.findOne("testuser@mail.com");
        List<Task> tasks = taskService.findUserTask(user);
        Assert.assertNotNull(tasks);
    }

}
