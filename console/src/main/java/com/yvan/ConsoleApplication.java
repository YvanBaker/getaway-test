package com.yvan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author v_yangfeng01
 * @date 2021/2/12
 */
@SpringBootApplication
public class ConsoleApplication {
    public static void main(String[] args){
      SpringApplication app = new SpringApplication(ConsoleApplication.class);
      app.run(args);
    }
}
