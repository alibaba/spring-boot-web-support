package com.alibaba.boot.web.autoconfigure;

import com.alibaba.boot.web.AbstractSpringBootTest;
import com.alibaba.boot.web.filter.NoopOrderedHiddenHttpMethodFilter;
import com.alibaba.boot.web.filter.NoopOrderedHttpPutFormContentFilter;
import com.alibaba.spring.util.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * {@link SpeedupWebMvcAutoConfiguration} Test with "disabled" profile
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see SpeedupWebMvcAutoConfiguration
 * @since 2017.04.11
 */
@ActiveProfiles("disabled")
public class SpeedupWebMvcAutoConfigurationDisabledTest extends AbstractSpringBootTest {

    @Test
    public void testNoopOrderedHiddenHttpMethodFilter() throws ServletException, IOException {

        Assert.assertFalse(BeanUtils.isBeanPresent(applicationContext, NoopOrderedHiddenHttpMethodFilter.class));

    }

    @Test
    public void testNoopOrderedHttpPutFormContentFilter() throws ServletException, IOException {

        Assert.assertFalse(BeanUtils.isBeanPresent(applicationContext, NoopOrderedHttpPutFormContentFilter.class));

    }

}
