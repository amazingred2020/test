package com.senlainc.service;

import com.senlainc.dao.FriendsInviteDao;
import com.senlainc.dao.GroupDao;
import com.senlainc.dao.GroupInviteDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.invite.SaveGroupInviteRequest;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.GroupInvite;
import com.senlainc.enums.Status;
import com.senlainc.mappers.invite.FriendInviteMapper;
import com.senlainc.mappers.invite.GroupInviteMapper;
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
    private GroupDao groupDao;

    @Autowired
    private FriendsInviteDao friendsInviteDao;

    @Autowired
    private GroupInviteDao groupInviteDao;

    @Autowired
    private GroupInviteMapper groupInviteMapper;

    @Autowired
    private FriendInviteMapper friendInviteMapper;

    @Override
    public void addFriendInvite(Long userFrom, Long userTo) {
        if(friendsInviteDao.findInvitesByUsersId(userFrom, userTo) == null){
            FriendInvite friendInvite = friendInviteMapper.fromIdsToFriendInvite(userFrom, userTo);
            friendInvite.setStatus(Status.WAIT);
            friendsInviteDao.save(friendInvite);
        }
    }

    @Override
    public List<FriendInvite> getAllFriendInvite(Long userId) {
        return friendsInviteDao.findInvitesByUserId(userId);
    }

    @Override
    public void addGroupInvite(SaveGroupInviteRequest request) {
        if(groupInviteDao.findInviteByUsersId(request.getUserFrom(), request.getUserTo()) == null) {
            GroupInvite groupInvite = groupInviteMapper.fromSaveGroupInviteRequestToGroup(request);
            groupInviteDao.save(groupInvite);
        }
    }

    @Override
    public List<GroupInvite> getAllGroupInvite(Long userId) {
        return groupInviteDao.findInvitesByUserId(userId);
    }


}
