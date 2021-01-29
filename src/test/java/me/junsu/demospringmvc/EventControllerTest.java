package me.junsu.demospringmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest({EventController.class, EventService.class, MyFormatter.class})
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHello() throws Exception {
        this.mockMvc.perform(get("/hello/junsu"))
                .andDo(print())
                .andExpect(content().string("hello junsu"));
    }

    @Test
    public void getHi() throws Exception {
        this.mockMvc.perform(get("/hi/junsulee"))
                .andDo(print())
                .andExpect(content().string("hi junsulee"));
    }
}