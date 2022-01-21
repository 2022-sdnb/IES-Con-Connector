package com.example.connector.gateway.device;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeviceGatewayImplTest {
    DeviceGateway gateway = new DeviceGatewayImpl();

    @BeforeAll
    static void initAll() {}

    @BeforeEach
    void init() {
        gateway.init(new ArrayList<>());
    }

    @Test
    void testGetAllAddrs() {
        assertEquals(0, gateway.getAllAddrs().size());
    }

    @AfterEach
    void tearDown() {}

    @AfterAll
    static void tearDownAll() {}
}
