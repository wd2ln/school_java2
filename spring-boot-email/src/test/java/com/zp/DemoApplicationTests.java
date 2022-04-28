package com.zp;

import com.zp.service.SendEmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private SendEmailService sendEmailService;
    @Test
    void contextLoads() {
        sendEmailService.send();
    }

}
