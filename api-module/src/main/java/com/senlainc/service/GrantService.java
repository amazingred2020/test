package com.senlainc.service;

import com.senlainc.entity.Grant;

public interface GrantService {

    Grant saveGrant(Grant grant);
    Grant findGrantById(Long id);
    void deleteGrant(Long id);
}
