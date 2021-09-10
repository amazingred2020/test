package com.senlainc.unit.user;

import com.senlainc.dao.FriendshipDao;
import com.senlainc.dto.user.AddFriendRequest;
import com.senlainc.dto.user.GetUserRequest;
import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.entity.Friendship;
import com.senlainc.entity.User;
import com.senlainc.enums.Gender;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.UserService;
import com.senlainc.TestConfiguration;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendshipDao friendshipDao;

    @Test
    public void testFindUserById(){
        User user = userService.findUserById(1l);

        Assert.assertNotNull(user);
    }

    @Test
    public void testSaveUser(){
        SaveUserRequest request = new SaveUserRequest();
        request.setFirstName("name");
        request.setLastName("surname");
        request.setUsername("someNickname");
        request.setPassword("somePassword");
        request.setGender(Gender.MAN);
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
        request.setUserFrom(4l);
        request.setUserTo(1l);
        request.setButtonName("confirm");
        userService.addFriend(request);
        Friendship friendship = friendshipDao.getFriendship(4l,1l);
        Assert.assertFalse(friendship.getId() == null);
    }

    @Test(expected = NoResultException.class)
    public void testDeleteFriend(){
        userService.deleteFriend(1l,2l);
        Friendship friendship = friendshipDao.getFriendship(1l, 2l);
    }

    @Test
    public void testGetFriendship(){
        Friendship friendship = friendshipDao.getFriendship(3l, 7l);
        Assert.assertTrue(friendship.getId() == 8l);
    }

    @Test
    public void changeRole(){
        userService.changeRole(1l, 2l);
        User user = userService.findUserById(1l);

        Assert.assertEquals(Long.valueOf(2), user.getRole().getId());
    }

    @Test
    public void testFindUsersByParameters(){
        GetUserRequest request = new GetUserRequest();
        request.setName("Петя");
        request.setSurname("Иванов");
        List<User> users = userService.findUsersByParameters(request);

        Assert.assertTrue(users.size() > 0);
    }
}
