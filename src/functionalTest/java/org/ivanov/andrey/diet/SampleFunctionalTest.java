package org.ivanov.andrey.diet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SampleFunctionalTest {

    @Test
    void contextLoads() {
        assertThat(true).isTrue();
    }
}