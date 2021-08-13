package com.senlainc.mappers.invite;

import com.senlainc.dao.GroupDao;
import com.senlainc.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupByIdMapper {

    @Autowired
    private GroupDao groupDao;

    public Group fromIdToGroup(Long id){
        return groupDao.findById(id);
    }
}
