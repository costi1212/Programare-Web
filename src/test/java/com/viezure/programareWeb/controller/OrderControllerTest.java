package com.viezure.programareWeb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class OrderControllerTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    @Test
    public void registerOrderTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/order/registerOrder/{username}", "user1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"discount\": 80, \"subtotal\": 300, \"grandTotal\": 240}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void registerOrderErrorTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/order/registerOrder/{username}", "not existing")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"discount\": 80, \"subtotal\": 300, \"grandTotal\": 240}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
