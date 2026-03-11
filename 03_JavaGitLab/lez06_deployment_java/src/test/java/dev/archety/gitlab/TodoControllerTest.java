package dev.archety.gitlab;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TodoController controller;

    @BeforeEach
    void setup() {
        controller.resetForTests();
    }

    @Test
    void list_shouldReturnEmptyArrayAtStart() throws Exception {
        mvc.perform(get("/api/todos").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void create_shouldAddTodoAndReturnIt() throws Exception {
        mvc.perform(post("/api/todos")
                        .param("title", "Studiare Spring")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Studiare Spring"));

        mvc.perform(get("/api/todos").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Studiare Spring"));
    }

    @Test
    void create_withoutTitleParam_shouldReturn400() throws Exception {
        mvc.perform(post("/api/todos"))
                .andExpect(status().isBadRequest());
    }
}