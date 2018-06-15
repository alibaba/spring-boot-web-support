package com.alibaba.boot.web;

import boot.BootApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * {@link AbstractSpringBootTest}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy<a/>
 * @version 1.0.0
 * @see AbstractSpringBootTest
 * @since 1.0.0 2016-07-18
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractSpringBootTest {

    @Autowired
    protected ApplicationContext applicationContext;

}
