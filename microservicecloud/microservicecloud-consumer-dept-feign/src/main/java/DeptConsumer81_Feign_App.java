import com.sam.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //启用eureka客户端功能，结合ribbon使用客户端负载均衡
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class) //指定部门服务消费者使用自定义对部门微服务规则\
@EnableFeignClients(basePackages= {"com.sam.springcloud"})
//@ComponentScan("com.atguigu.springcloud")

public class DeptConsumer81_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer81_Feign_App.class,args);
    }
}
