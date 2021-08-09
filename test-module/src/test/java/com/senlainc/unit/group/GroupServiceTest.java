package com.senlainc.unit.group;

import com.senlainc.dao.GroupDao;
import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.NewGroupRequest;
import com.senlainc.entity.Group;
import com.senlainc.entity.User;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.GroupService;
import com.senlainc.testconfig.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupServiceTest {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupDao groupDao;

    @Test(expected = NullPointerException.class)
    public void testDeleteGroup(){
        Long id = 1l;
        groupService.deleteGroup(id);
        User user = groupDao.findById(id).getUser();
    }

    @Test(expected = NullPointerException.class)
    public void testAddUserToGroup(){
        GroupUserRequest request = new GroupUserRequest();
        request.setGroupId(1l);
        request.setFromId(1l);
        request.setUserId(2l);
        groupService.addUserToGroup(request);
        Set<User> users = groupDao.findById(1l).getUsers();
    }

    @Test
    public void testRemoveUserFromGroup(){
        groupService.removeUserFromGroup(1l,1l);
        Set<User> users = groupDao.findById(1l).getUsers();

        Assert.assertTrue(users.size() == 0);
    }

    @Test
    public void testAddGroup(){
        NewGroupRequest request = new NewGroupRequest();
        request.setName("group name");
        request.setDescription("group description");
        request.setUserId(1l);
        groupService.addGroup(request);
        String description = groupDao.findByName("group name").getDescription();

        Assert.assertSame("group description", description);
    }

    @Test
    public void testChangeAdmin(){
        groupService.changeAdmin(1l, 2l);
        Long id = groupDao.findById(1l).getUser().getId();

        Assert.assertEquals(Long.valueOf(2), id);
    }
}
