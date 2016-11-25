package org.tcat.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring boot 启动器
 * Created by Lin on 2016/11/24.
 */
@RestController
@ServletComponentScan
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
