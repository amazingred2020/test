package com.senlainc.unit.privilege;

import com.senlainc.dto.privileges.NewRoleRequest;
import com.senlainc.entity.Role;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindRoleById(){
        Role role = roleService.findRoleById(1l);

        Assert.assertNotNull(role.getCreatedAt());
    }

    @Test
    public void testDeleteRole(){
        Long id = 1l;
        roleService.deleteRole(id);
        Assert.assertEquals("not equals!", null, roleService.findRoleById(id));
    }

    @Test
    public void testCreateNewRole(){
        NewRoleRequest request = new NewRoleRequest();
        request.setRoleName("testRole");
        request.setPrivileges(Arrays.asList(new String[]{"create","update"}));
        roleService.createNewRole(request);

        Assert.assertEquals("not equals!", 2, roleService.findRoleById(5l).getPrivileges().size());
    }
}
