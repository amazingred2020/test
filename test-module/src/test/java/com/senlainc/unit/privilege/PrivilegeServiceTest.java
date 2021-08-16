package com.senlainc.unit.privilege;

import com.senlainc.entity.Privilege;
import com.senlainc.jpaconfig.JpaConfiguration;
import com.senlainc.service.PrivilegeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfiguration.class)
public class PrivilegeServiceTest {

    @Autowired
    private PrivilegeService privilegeService;

    @Test
    public void testSavePrivilege(){
        Privilege privilege = new Privilege("test");
        privilege = privilegeService.savePrivilege(privilege);

        Assert.assertEquals(Long.valueOf(5), privilege.getId());
    }

    @Test
    public void testFindPrivilegeById(){
        Long id = 2l;
        String name = privilegeService.findPrivilegeById(id).getName();

        Assert.assertNotSame("delete", name);
    }

    @Test
    public void testDeletePrivilege(){
        Long id = 4l;
        privilegeService.deletePrivilege(id);

        Assert.assertNull(privilegeService.findPrivilegeById(id));
    }
}
