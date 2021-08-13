package com.senlainc.mock.privilege;

import com.senlainc.controller.privilege.PrivilegeController;
import com.senlainc.entity.Privilege;
import com.senlainc.routes.PrivilegeRoutes;
import com.senlainc.service.PrivilegeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.*;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class PrivilegeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PrivilegeService privilegeService;

    @InjectMocks
    private PrivilegeController privilegeController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(privilegeController).build();
    }

    @Test
    public void testCreatePrivilege() throws Exception {
        Privilege privilege = mock(Privilege.class, "privilegeName");
        when(privilegeService.savePrivilege(privilege))
                .thenReturn(mock(Privilege.class));

        mockMvc.perform(get("/privilege")
                .param("name", "privilegeName"))
                .andExpect(status().is(200));

        verify(privilegeService, times(1))
                .savePrivilege(Matchers.any(Privilege.class));
    }

    @Test
    public void testDeletePrivilege() throws Exception {
        doNothing().when(privilegeService).deletePrivilege(eq(1l));

      //  mockMvc.perform(delete(PrivilegeRoutes.DELETE_PRIVILEGE, 1l))
        //        .andExpect(status().is(405));

        verify(privilegeService, never()).deletePrivilege(1l);
    }
}
