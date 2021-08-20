package com.senlainc.controller.privilege;

import com.senlainc.dto.privileges.SaveRoleRequest;
import com.senlainc.routes.PrivilegeRoutes;
import com.senlainc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(PrivilegeRoutes.ROLE)
    public void createRole(@RequestBody @Validated SaveRoleRequest newRoleRequest){
        roleService.createNewRole(newRoleRequest);
    }

    @DeleteMapping(PrivilegeRoutes.ROLE_BY_ID)
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }
}
