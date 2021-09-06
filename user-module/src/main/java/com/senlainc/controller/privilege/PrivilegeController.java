package com.senlainc.controller.privilege;

import com.senlainc.entity.Privilege;
import com.senlainc.routes.PrivilegeRoutes;
import com.senlainc.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping(PrivilegeRoutes.PRIVILEGE)
    public void createPrivilege(@RequestParam String name){
        privilegeService.savePrivilege(new Privilege(name));
    }

    @DeleteMapping(PrivilegeRoutes.PRIVILEGE_BY_ID)
    public void deletePrivilege(@PathVariable Long id){
        privilegeService.deletePrivilege(id);
    }

}
