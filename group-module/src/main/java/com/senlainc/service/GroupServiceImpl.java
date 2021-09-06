package com.senlainc.service;

import com.senlainc.dao.GroupDao;
import com.senlainc.dao.GroupInviteDao;
import com.senlainc.dao.SubscriberDao;
import com.senlainc.dao.UserDao;
import com.senlainc.dto.group.SaveGroupRequest;
import com.senlainc.dto.group.GroupUserRequest;
import com.senlainc.entity.Group;
import com.senlainc.entity.Subscriber;
import com.senlainc.enums.Status;
import com.senlainc.mappers.group.GroupMapper;
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
    private SubscriberDao subscriberDao;

    @Autowired
    private GroupInviteDao groupInviteDao;

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public void deleteGroup(Long id) {
        groupDao.remove(id);
    }

    @Override
    public void addUserToGroup(GroupUserRequest request) {
        if(request.getButtonName().equals("confirm")) {
            Subscriber subscriber = groupMapper.fromGroupUserRequestToSubscriber(request);
            subscriberDao.save(subscriber);
            groupInviteDao.findInviteByUsersId(request.getFromId(), request.getUserId())
                    .get().setStatus(Status.CONFIRM);
        } else {
            groupInviteDao.findInviteByUsersId(request.getFromId(), request.getUserId())
                    .get().setStatus(Status.REJECT);
        }
    }

    @Override
    public void removeUserFromGroup(Long groupId, Long userId) {
        subscriberDao.delete(groupId, userId);
    }

    @Override
    public void addGroup(SaveGroupRequest request) {
        Group newGroup = groupMapper.fromGroupRequestToGroup(request);
        Group group = groupDao.save(newGroup);
        Subscriber subscriber = new Subscriber();
        subscriber.setUser(userDao.findById(request.getUserId()));
        subscriber.setGroup(group);
        subscriberDao.save(subscriber);
    }

    @Override
    public void changeAdmin(Long groupId, Long userId) {
        Group group = groupDao.findById(groupId);
        group.setUser(userDao.findById(userId));
        groupDao.save(group);
    }
}
