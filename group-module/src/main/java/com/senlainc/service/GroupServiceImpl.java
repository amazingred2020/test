package com.senlainc.service;

import com.senlainc.dao.GroupDao;
import com.senlainc.dao.GroupInviteDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.group.NewGroupRequest;
import com.senlainc.entity.Group;
import com.senlainc.entity.GroupInvite;
import com.senlainc.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupInviteDao groupInviteDao;

    @Override
    public Group saveGroup(Group group) {
        return groupDao.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        groupDao.remove(id);
    }

    @Override
    public void addUserToGroup(Long groupId, Long userId, Long userFromId) {
        Group group = groupDao.findById(groupId);
        GroupInvite groupInvite = groupInviteDao.save(new GroupInvite(
                userDao.findById(userFromId), userDao.findById(userId), Status.WAIT));
        changeGroupInviteStatus(groupInvite);
        if(groupInvite.getStatus() == Status.CONFIRM) {
            groupDao.findById(groupId).addUserToGroup(userDao.findById(userId));
        }
    }

    private void changeGroupInviteStatus(GroupInvite groupInvite) {
        if(Math.random() < 0.5){
            groupInvite.setStatus(Status.CONFIRM);
        } else {
            groupInvite.setStatus(Status.REJECT);
        }
    }

    @Override
    public void removeUserFromGroup(Long groupId, Long userId) {
        groupDao.findById(groupId).removeUserFromGroup(userDao.findById(userId));
    }

    @Override
    public void addGroup(NewGroupRequest request) {
        Group newGroup = new Group(request.getName());
        newGroup.setAdmin(userDao.findById(request.getUserId()));
        if(request.getDescription() != null){
            newGroup.setDescription(request.getDescription());
        }
        groupDao.save(newGroup);
    }

    @Override
    public void changeAdmin(Long groupId, Long userId) {
        Group group = groupDao.findById(groupId);
        group.setAdmin(userDao.findById(userId));
        groupDao.save(group);
    }
}
