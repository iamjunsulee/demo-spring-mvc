package me.junsu.demospringmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SampleController.class)
class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEvent() throws Exception {
        this.mockMvc.perform(get("/event/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("1"))
        ;
    }

    @Test
    public void getParameterTest() throws Exception {
        this.mockMvc.perform(post("/event"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void getModelAttributeTest() throws Exception {
        this.mockMvc.perform(post("/event/create")
                    .param("limitOfEnrollment", "junsu"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void modelAttributeTest() throws Exception {
        this.mockMvc.perform(get("/event/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("categories"));
    }
}