package com.senlainc.controller;

import com.senlainc.dto.privileges.NewRoleRequest;
import com.senlainc.entity.Grant;
import com.senlainc.service.GrantService;
import com.senlainc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/privilege")
public class PrivilegeController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private GrantService grantService;

    @PostMapping(value = "/role")
    public void createRole(@RequestBody @Valid NewRoleRequest newRoleRequest, BindingResult result){
        if(!result.hasErrors()) roleService.createNewRole(newRoleRequest);
    }

    @GetMapping(value = "/role/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }

    @GetMapping(value = "/grant")
    public void createGrant(@RequestParam String name){
        grantService.saveGrant(new Grant(name));
    }

    @GetMapping(value = "/grant/{id}")
    public void deleteGrant(@PathVariable Long id){
        grantService.deleteGrant(id);
    }

}
