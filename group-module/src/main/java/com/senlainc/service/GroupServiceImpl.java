package com.senlainc.service;

import com.senlainc.dao.GroupDao;
import com.senlainc.entity.Group;
import com.senlainc.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public Group saveGroup(Group group) {
        return groupDao.save(group);
    }

    public void addUserToGroup(Long groupId, Long userId){
        groupDao.addUserToGroup(groupId, userId);
    }

    public void removeUserFromGroup(Long groupId, Long userId){
        groupDao.removeUserFromGroup(groupId, userId);
    }
}