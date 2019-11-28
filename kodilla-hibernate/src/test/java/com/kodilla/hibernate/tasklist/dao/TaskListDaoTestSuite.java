package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "Name";

    @Test
    public void testFindByListName() {

        TaskList taskList = new TaskList(LISTNAME, "Description");
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        List<TaskList> theList = taskListDao.findByListName(listName);

        Assert.assertEquals(1, theList.size());

        int id = theList.get(0).getId();
        taskListDao.deleteById(id);
    }
}