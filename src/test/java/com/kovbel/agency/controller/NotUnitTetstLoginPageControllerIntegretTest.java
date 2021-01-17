package com.kovbel.agency.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("Andrij")
public class NotUnitTetstLoginPageControllerIntegretTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    InfoController infoController;

    @Test
    public void accessDeniedUserMustLogin() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void loginUserInToMainPageTest() throws Exception {
        this.mockMvc.perform(formLogin().user("Galyna").password("12345"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }


    @Test
    public void badCredentialsTest() throws Exception {
        this.mockMvc.perform(post("/login").param("user", "something"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void accessDeniedTest() throws Exception {
        this.mockMvc.perform(get("/form").param("Andrij", "Andrij"))
                .andDo(print())
                .andExpect(authenticated())
                .andExpect(status().isForbidden());
    }
}