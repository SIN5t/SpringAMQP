package cn.edu.uestc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testFanoutExchange(){
        //交换机名称
        String exchangeName = "uestc.fanout";
        String msg = "hello fanoutMsg";
        for (int i = 0; i < 1; i++) {
            rabbitTemplate.convertAndSend(exchangeName,"",msg);
        }
    }

    @Test
    public void testDirectExchange(){
        //交换机名称
        String exchangeName = "directExchange";
        String msg = "hello DirectMsg";
        for (int i = 0; i < 1; i++) {
            rabbitTemplate.convertAndSend(exchangeName,"white",msg);
        }
    }

    @Test
    public void testTopicExchange(){
        //交换机名称
        String exchangeName = "TopicExchange";
        String msg = "hello TopicMsg";
        for (int i = 0; i < 1; i++) {
            rabbitTemplate.convertAndSend(exchangeName,"China.tec",msg);
        }
    }
    @Test
    public void testSendMap() throws InterruptedException {
        Map<String,String> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","21");
        String queueName = "workQueue";
        rabbitTemplate.convertAndSend(queueName,map);

    }

}
