package com.senlainc.service;

import com.senlainc.dao.FriendsInviteDao;
import com.senlainc.dao.GroupInviteDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.invite.AddGroupInviteRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;
import com.senlainc.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InviteServiceImpl implements InviteService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private FriendsInviteDao friendsInviteDao;

    @Autowired
    private GroupInviteDao groupInviteDao;

    @Override
    public void addFriendInvite(Long fromId, Long toId) {
        FriendInvite friendInvite = new FriendInvite(userDao.findById(fromId), userDao.findById(toId));
        friendInvite.setStatus(Status.WAIT);
        friendsInviteDao.save(friendInvite);
    }

    @Override
    public List<FriendInvite> getAllFriendInvite(Long userId) {
        return friendsInviteDao.findInvitesByUserId(userId);
    }

    @Override
    public void addGroupInvite(AddGroupInviteRequest request) {
        GroupInvite groupInvite = new GroupInvite(userDao.findById(request.getUserFrom()),
                userDao.findById(request.getUserTo()));
        groupInvite.setStatus(Status.WAIT);
        groupInviteDao.save(groupInvite);
    }

    @Override
    public List<GroupInvite> getAllGroupInvite(Long userId) {
        return groupInviteDao.findInvitesByUserId(userId);
    }


}
