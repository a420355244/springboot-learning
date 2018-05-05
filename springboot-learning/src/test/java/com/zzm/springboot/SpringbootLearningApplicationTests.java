package com.zzm.springboot;

import com.zzm.springboot.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearningApplicationTests {

    @Autowired
    private Person person;
    @Autowired
    private ApplicationContext ioc;
    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testImportSources(){
        HelloService helloService = (HelloService) ioc.getBean("helloService");
        helloService.sayHello();
    }

}
