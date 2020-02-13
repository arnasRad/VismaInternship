package com.arnasrad.vismainternship;

import com.arnasrad.vismainternship.dnb.psd2.service.UuidService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class UuidComponentTests {

    @Autowired
    UuidService uuidService;

    @Test
    public void whenGet2UUIDs_thenUUIDsNotEqual() {

        String uuid1 = uuidService.getUUID();
        String uuid2 = uuidService.getUUID();

        assertNotEquals(uuid1, uuid2);
    }

}