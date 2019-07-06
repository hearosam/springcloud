package sam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@SpringBootApplication
@EnableEurekaServer
public class Eureka7001APP {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7001APP.class,args);
    }
}
