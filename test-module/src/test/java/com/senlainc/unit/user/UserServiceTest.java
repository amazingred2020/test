package com.senlainc.unit.user;

import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.UserCriteriaRequest;
import com.senlainc.dto.user.UserRequest;
import com.senlainc.entity.User;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.UserService;
import com.senlainc.testconfig.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserById(){
        User user = userService.findUserById(1l);

        Assert.assertNotNull(user);
    }

    @Test
    public void testSaveUser(){
        UserRequest request = new UserRequest();
        request.setFirstName("name");
        request.setLastName("surname");
        request.setUsername("someNickname");
        request.setPassword("somePassword");
        request.setGender("gender");
        request.setCity("city");
        request.setEmail("mailonetwothree@mail.ru");
        request.setRoleId(1l);

        User user = userService.saveUser(request);

        Assert.assertNotNull(user.getId());
        Assert.assertTrue("name".equals(user.getFirstName()));
    }

    @Test
    public void testAddFriend(){
        AddFriendRequest request = new AddFriendRequest();
        request.setUserFrom(2l);
        request.setUserTo(4l);
        request.setButtonName("confirm");
        userService.addFriend(request);
        User user = userService.findUserById(2l);

        Assert.assertFalse(user.getFriends().isEmpty());
    }

    @Test
    public void testDeleteFriend(){
        userService.deleteFriend(2l,1l);
        User user = userService.findUserById(2l);

        Assert.assertTrue(user.getFriends().size() == 1);
    }

    @Test
    public void changeRole(){
        userService.changeRole(4l, 3l);
        User user = userService.findUserById(4l);

        Assert.assertEquals(Long.valueOf(3), user.getRole().getId());
    }

    @Test
    public void testFindUsersByCriteria(){
        UserCriteriaRequest request = new UserCriteriaRequest();
        request.setName("Иван");
        request.setSurname("Cидоров");
        List<User> users = userService.findUsersByCriteria(request);

        Assert.assertTrue(users.size() > 0);
    }
}
