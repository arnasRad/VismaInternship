package com.arnasrad.vismainternship.controller;

import com.arnasrad.vismainternship.controller.interbankingapi.AccountController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = AccountController.class)
public class InterbankingAccountControllerTests {

    private final WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    public InterbankingAccountControllerTests(WebApplicationContext webApplicationContext) {

        this.webApplicationContext = webApplicationContext;
    }

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void givenNoToken_whenGetSecureRevolutRequest_thenUnauthorized() throws Exception {

        mockMvc.perform(get("/interbanking/accounts")
                .param("bank", "revolut"))
                .andExpect(status().isUnauthorized());
    }
}
