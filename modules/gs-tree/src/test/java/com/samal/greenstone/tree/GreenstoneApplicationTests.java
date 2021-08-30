package com.samal.greenstone.tree;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles({"test"})
class GreenstoneApplicationTests {
    @Test
    void contextLoads() {
        // First Jira trigger
        System.out.println("Test");
        assertTrue(true);
    }
}
