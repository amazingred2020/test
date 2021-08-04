package com.senlainc.principal;

import com.senlainc.entity.Grant;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private Grant grant;

    public CustomGrantedAuthority(Grant grant){
        this.grant = grant;
    }

    @Override
    public String getAuthority() {
        return grant.getName();
    }
}
