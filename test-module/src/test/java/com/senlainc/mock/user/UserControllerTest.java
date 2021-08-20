package com.senlainc.mock.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senlainc.controller.user.UserController;
import com.senlainc.dto.user.SaveUserRequest;
import com.senlainc.entity.Role;
import com.senlainc.entity.User;
import com.senlainc.enums.Gender;
import com.senlainc.routes.UserRoutes;
import com.senlainc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testAddUser() throws Exception {
        SaveUserRequest request = new SaveUserRequest("name","surname", Gender.MAN,
        "nickname", "password", "email@mail.ru","city",1l);

        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setFirstName("name");
        user.setLastName("surname");
        user.setGender(Gender.MAN);
        user.setUsername("nickname");
        user.setPassword("password");
        user.setEmail("email@mail.ru");
        user.setCity("city");
        user.setRole(new Role());

        when(userService.saveUser(request)).thenReturn(user);

        mockMvc.perform(post(UserRoutes.USER)
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, atLeastOnce()).saveUser(Matchers.any(SaveUserRequest.class));
    }

    @Test
    public void testFindUserById() throws Exception {
        SaveUserRequest request = new SaveUserRequest("name","surname",Gender.MAN,
                "nickname", "password", "email@mail.ru","city",1l);

        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setFirstName("name");
        user.setLastName("surname");
        user.setGender(Gender.MAN);
        user.setUsername("nickname");
        user.setPassword("password");
        user.setEmail("email@mail.ru");
        user.setCity("city");
        user.setRole(new Role());

        when(userService.findUserById(1l)).thenReturn(user);

        mockMvc.perform(get(UserRoutes.USER_BY_ID, 1l)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
