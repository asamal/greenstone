package com.samal.greenstone.core.api;

import com.samal.greenstone.core.domain.Tree;
import com.samal.greenstone.core.service.TreeService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TreeController.class)
@ComponentScan(basePackages = "com.samal.greenstone.core.api.dto")
class TreeControllerWebTestClientTest {
    @Autowired
    MockMvc mockMvc;

    private WebTestClient webTestClient;

    @MockBean
    TreeService treeService;

    @Test
    void findOne() {
        Tree tree = new Tree();
        tree.setId(1L);
        tree.setDescription("Desc");
        when(treeService.findById(1L)).thenReturn(Optional.of(tree));

        webTestClient.get().uri("/trees/1")
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.id", Matchers.is(1L))
                .hasJsonPath().jsonPath("$.desc", Matchers.is("Desc"));
    }

    @Test
    void create() {
        Tree tree = new Tree();
        tree.setId(1L);
        tree.setDescription("Desc");
        when(treeService.save(any())).thenReturn(tree);

        webTestClient.put().uri("/trees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue("""
                        {
                          "id": 1,
                          "desc": "Desc"
                        }""")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.id", Matchers.is(1L))
                .hasJsonPath().jsonPath("$.desc", Matchers.is("Desc"));

    }

    @Test
    void create_emptyDesc() {
        webTestClient.put()
                .uri("/trees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue("""
                        {
                          "id": 1,
                          "desc": ""
                        }""")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @BeforeEach
    public void setup() {
        this.webTestClient = MockMvcWebTestClient
                .bindTo(mockMvc)
                .defaultHeader("X-Duke", "42")
                .filter(logRequest())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            System.out.printf("Request: %s %s %n", clientRequest.method(), clientRequest.url());
            return next.exchange(clientRequest);
        };
    }
}