package com.senlainc.unit.group;

import com.senlainc.dao.GroupDao;
import com.senlainc.dao.SubscriberDao;
import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.entity.Group;
import com.senlainc.entity.Subscriber;
import com.senlainc.entity.User;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.GroupService;
import com.senlainc.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Set;
import static org.mockito.Mockito.*;

@Transactional
@ContextConfiguration(classes = {JpaConfiguration.class, TestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GroupServiceTest {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private SubscriberDao subscriberDao;

    @Test
    public void testDeleteGroup(){
        Long id = 1l;
        groupService.deleteGroup(id);
        Group group = groupDao.findById(id);
    }

    @Test(expected = NoResultException.class)
    public void testRemoveUserFromGroup(){
        groupService.removeUserFromGroup(1l,1l);
        Subscriber subscriber = subscriberDao.findByUserAndGroupId(1l, 1l);
    }

    @Test
    public void testGetSubscriber(){
        Subscriber subscriber = subscriberDao.findByUserAndGroupId(4l, 1l);
        Assert.assertTrue(subscriber.getId() == 5l);
    }

    @Test
    public void testAddGroup(){
        SaveGroupRequest request = new SaveGroupRequest();
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
