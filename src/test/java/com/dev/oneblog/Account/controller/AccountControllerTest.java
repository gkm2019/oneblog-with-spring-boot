package com.dev.oneblog.Account.controller;

import com.dev.oneblog.Account.entity.AccountEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by kyeongmin ku
 */
/*
Junit 4
@RunWith(SpringRunner.class)
@SpringBootTest
 */

@WebAppConfiguration
@ExtendWith(SpringExtension.class) //Junit5
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    @DisplayName("index page에 anonymous 접근")
    public void index_anonymous() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username="kyeongmin", roles="USER")
    @DisplayName("index page에 USER 접근")
    public void index_user() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithUser
    @DisplayName("admin page USER 접근")
    public void admin_user() throws Exception {
        mockMvc.perform(get("/admin").with(user("kyeongmin").roles("USER")))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("admin page ADMIN 접근")
    public void admin_admin() throws Exception {
        mockMvc.perform(get("/admin").with(user("kyeongmin").roles("ADMIN")))
                .andDo(print())
                .andExpect(status().isOk());
    }
}