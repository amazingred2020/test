package com.senlainc.dao;

import com.senlainc.entity.Grant;

public interface GrantDao {

    Grant save(Grant grant);
    Grant findById(Long id);
    void delete(Long id);
    Grant findGrantByName(String name);
}
