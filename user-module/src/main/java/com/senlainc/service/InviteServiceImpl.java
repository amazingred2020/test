package com.senlainc.service;

import com.senlainc.dao.InviteDao;
import com.senlainc.entity.FriendInvite;
import com.senlainc.entity.Invite;
import com.senlainc.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InviteServiceImpl implements InviteService {

    @Autowired
    private InviteDao inviteDao;

    @Override
    public void save(FriendInvite invite) {
        inviteDao.saveFriendsInvite(invite);
    }

    @Override
    public void deleteFriendInvite(Long id) {
        inviteDao.deleteFriendInvite(id);
    }

    @Override
    public void deleteInviteByUserToId(Long userTo){
        inviteDao.deleteInviteByUserToId(userTo);
    }

    @Override
    public FriendInvite changeInviteStatus(FriendInvite friendInvite) {
        if(Math.random() < 0.5){
            friendInvite.setStatus(Status.CONFIRM);
        } else {
            friendInvite.setStatus(Status.REJECT);
        }

        return friendInvite;
    }


}
