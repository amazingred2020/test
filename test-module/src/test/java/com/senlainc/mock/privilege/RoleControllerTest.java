package com.senlainc.mock.privilege;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senlainc.controller.privilege.RoleController;
import com.senlainc.dto.privileges.SaveRoleRequest;
import com.senlainc.routes.PrivilegeRoutes;
import com.senlainc.service.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class RoleControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RoleService roleService;

    @InjectMocks
    private RoleController roleController;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
    }

    @Test
    public void testCreateRole() throws Exception {
        SaveRoleRequest request = new SaveRoleRequest();
        request.setPrivileges(Arrays.asList("create", "delete"));
        request.setRoleName("newRole");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(request);

        doNothing().when(roleService).createNewRole(request);

        mockMvc.perform(post(PrivilegeRoutes.ROLE).content(json)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDeleteRole() throws Exception {
        doNothing().when(roleService).deleteRole(eq(1l));

        mockMvc.perform(delete(PrivilegeRoutes.ROLE_BY_ID, 1l))
                .andExpect(status().is2xxSuccessful());

        verify(roleService, times(1)).deleteRole(anyLong());
    }

}
