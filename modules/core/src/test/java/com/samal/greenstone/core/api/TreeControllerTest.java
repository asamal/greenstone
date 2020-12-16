package com.samal.greenstone.core.api;

import com.samal.greenstone.core.domain.Tree;
import com.samal.greenstone.core.service.TreeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TreeController.class)
class TreeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TreeService treeService;

    @Test
    void findOne() throws Exception {
        Tree tree = new Tree();
        tree.setId(1L);
        tree.setDescription("Desc");
        when(treeService.findById(1L)).thenReturn(Optional.of(tree));

        mockMvc.perform(get("/trees/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.desc").value("Desc"));
    }

    @Test
    void create() throws Exception {
        Tree tree = new Tree();
        tree.setId(1L);
        tree.setDescription("Desc");
        when(treeService.save(any())).thenReturn(tree);

        mockMvc.perform(put("/trees")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content("""
                        {
                          "id": 1,
                          "desc": "Desc"
                        }""")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.desc").value("Desc"));

    }

    @Test
    void create_emptyDesc() throws Exception {

        mockMvc.perform(put("/trees")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE).content("""
                        {
                          "id": 1,
                          "desc": ""
                        }""")
        )
                .andExpect(status().isBadRequest());

    }
}