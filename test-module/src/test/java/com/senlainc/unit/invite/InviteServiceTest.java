package com.senlainc.unit.invite;

import com.senlainc.dao.FriendsInviteDao;
import com.senlainc.dao.GroupInviteDao;
import com.senlainc.dto.invite.AddGroupInviteRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.InviteService;
import com.senlainc.testconfig.TestConfiguration;
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
public class InviteServiceTest {

    @Autowired
    private InviteService inviteService;

    @Autowired
    private FriendsInviteDao friendsInviteDao;

    @Autowired
    private GroupInviteDao groupInviteDao;

    @Test(expected = NoResultException.class)
    public void testAddFriendInvite(){
        inviteService.addFriendInvite(1l, 2l);
        FriendInvite friendInvite = friendsInviteDao.findInvitesByUsersId(1l, 2l);

        Assert.assertNotNull(friendInvite);
    }

    @Test
    public void  testGetAllFriendInvite(){
        List<FriendInvite> invites = inviteService.getAllFriendInvite(4l);

        Assert.assertTrue(invites.size() > 0);
    }

    @Test(expected = NoResultException.class)
    public void testAddGroupInvite(){
        AddGroupInviteRequest request = new AddGroupInviteRequest();
        request.setGroupId(1l);
        request.setUserFrom(2l);
        request.setUserTo(1l);
        inviteService.addGroupInvite(request);
        GroupInvite groupInvite = groupInviteDao.findInviteByUsersId(2l, 1l);

        Assert.assertNotNull(groupInvite);
    }

    @Test
    public void testGetAllGroupInvite(){
        List<GroupInvite> invites = inviteService.getAllGroupInvite(1l);

        Assert.assertFalse(invites.isEmpty());
    }
}
