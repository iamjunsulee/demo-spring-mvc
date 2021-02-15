package me.junsu.demospringmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest({EventController.class, EventService.class, MyConverter.class, MyInterceptor.class})
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

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

    @Test
    public void getUser() throws Exception {
      this.mockMvc.perform(get("/user").param("id", "1"))
              .andDo(print())
              .andExpect(content().string("Mr.Lee"));
    }

    @Test
    public void getMessage() throws Exception {
        this.mockMvc.perform(get("/message").content("hello-junsu"))
                .andDo(print())
                .andExpect(content().string("hello-junsu"))
                ;
    }

    @Test
    public void getJsonMessage() throws Exception {
        User user = new User(1L, "leejunsu");
        String valueAsString = mapper.writeValueAsString(user);
        this.mockMvc.perform(get("/message")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(valueAsString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("leejunsu"))
        ;
    }

    @Test
    public void getHttpMethodTest() throws Exception {
        this.mockMvc.perform(post("/method"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("post"))
                .andExpect(handler().handlerType(EventController.class));

        this.mockMvc.perform(put("/method"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }
}