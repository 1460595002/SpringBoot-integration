package cn.jinronga.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan(value = "cn.jinronga.redis.dao")
@SpringBootApplication
@EnableSwagger2
public class RedisMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisMpApplication.class, args);
    }

}