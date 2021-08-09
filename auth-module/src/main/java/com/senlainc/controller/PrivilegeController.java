package com.senlainc.controller;

import com.senlainc.entity.Privilege;
import com.senlainc.routes.AuthRoutes;
import com.senlainc.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping(AuthRoutes.PRIVILEGE)
    public void createPrivilege(@RequestParam String name){
        privilegeService.savePrivilege(new Privilege(name));
    }

    @DeleteMapping(AuthRoutes.DELETE_PRIVILEGE)
    public void deletePrivilege(@PathVariable Long id){
        privilegeService.deletePrivilege(id);
    }

}
