package com.arnasrad.vismainternship;

import com.arnasrad.vismainternship.service.dnb.psd2api.UuidService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class UuidComponentTests {

    private final UuidService uuidService;

    @Autowired
    public UuidComponentTests(UuidService uuidService) {
        this.uuidService = uuidService;
    }

    @Test
    public void whenGet2UUIDs_thenUUIDsNotEqual() {

        String uuid1 = uuidService.getUUID();
        String uuid2 = uuidService.getUUID();

        assertNotEquals(uuid1, uuid2);
    }

}