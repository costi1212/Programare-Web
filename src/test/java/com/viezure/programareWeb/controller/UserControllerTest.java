package com.viezure.programareWeb.controller;

import com.viezure.programareWeb.repository.UserRepository;
import com.viezure.programareWeb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @Test
    public void getAllUsersAPI() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                    .get("/user/getAllUsers")
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").exists());
    }

    @Test
    public void registerUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"TestFName\", \"lastName\": \"TestLName\", \"email\": \"emailTest@yahoo.com\", \"phoneNumber\": \"123123123\", \"username\":\"user test\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void registerUserErrorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/user/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\": \"TestFName\", \"lastName\": \"TestLName\", \"email\": \"user3@gmail.com\", \"phoneNumber\": \"123123123\", \"username\":\"user test\"}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
