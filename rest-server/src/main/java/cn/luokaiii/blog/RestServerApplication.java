package cn.luokaiii.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot 启动入口
 *
 * @Date 2021/1/26
 */
@RestController
@SpringBootApplication
public class RestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServerApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
