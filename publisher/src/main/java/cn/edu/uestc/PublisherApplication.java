package cn.edu.uestc;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PublisherApplication {
    public static void main(String[] args) {
        SpringApplication.run(PublisherApplication.class, args);
    }
    @Bean
    public org.springframework.amqp.support.converter.MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}
