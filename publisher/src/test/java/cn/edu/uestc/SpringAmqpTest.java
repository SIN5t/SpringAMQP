package cn.edu.uestc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {

    @Resource
    RabbitTemplate rabbitTemplate;

    @Test
    public void testWorkQueue() throws InterruptedException {
        String queueName = "workQueue";
        String msg = "hello, rabbitMQ,YC";
        rabbitTemplate.convertAndSend(queueName,msg);
       for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName,msg+i);
            Thread.sleep(20);

        }

    }

}
