package com.example.poultryfarm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class PoultryfarmApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(PoultryfarmApplicationTests.class);

    @Test
    void contextLoads() {
        logger.info("Running contextLoads test...");
    }

}
