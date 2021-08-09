package com.senlainc.principal;

import com.senlainc.entity.Privilege;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private Privilege privilege;

    public CustomGrantedAuthority(Privilege privilege){
        this.privilege = privilege;
    }

    @Override
    public String getAuthority() {
        return privilege.getName();
    }
}
