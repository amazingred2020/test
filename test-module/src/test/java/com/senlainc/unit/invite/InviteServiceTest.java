package com.senlainc.unit.invite;

import com.senlainc.dao.FriendsInviteDao;
import com.senlainc.dao.GroupInviteDao;
import com.senlainc.dto.invite.SaveGroupInviteRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;
import com.senlainc.enums.Status;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.InviteService;
import com.senlainc.TestConfiguration;
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

    @Test
    public void testAddFriendInvite(){
        inviteService.addFriendInvite(1l, 2l);
        FriendInvite friendInvite = friendsInviteDao.findInvitesByUsersId(1l, 2l).get();

        Assert.assertNotNull(friendInvite);
    }

    @Test
    public void  testGetAllFriendInvite(){
        List<FriendInvite> invites = inviteService.getAllFriendInvite(1l);

        Assert.assertTrue(invites.size() > 0);
    }

    @Test
    public void testAddGroupInvite(){
        SaveGroupInviteRequest request = new SaveGroupInviteRequest();
        request.setGroupId(1l);
        request.setUserFrom(2l);
        request.setUserTo(1l);
        request.setStatus(Status.WAIT);
        inviteService.addGroupInvite(request);
        GroupInvite groupInvite = groupInviteDao.findInviteByUsersId(2l, 1l).get();

        Assert.assertNotNull(groupInvite);
    }

    @Test
    public void testGetAllGroupInvite(){
        List<GroupInvite> invites = inviteService.getAllGroupInvite(2l);

        Assert.assertFalse(invites.isEmpty());
    }
}
