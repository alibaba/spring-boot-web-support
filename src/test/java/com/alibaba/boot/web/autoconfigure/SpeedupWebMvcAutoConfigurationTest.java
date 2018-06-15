package com.alibaba.boot.web.autoconfigure;

import com.alibaba.boot.web.AbstractSpringBootTest;
import com.alibaba.boot.web.filter.NoopOrderedHiddenHttpMethodFilter;
import com.alibaba.boot.web.filter.NoopOrderedHttpPutFormContentFilter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * {@link SpeedupWebMvcAutoConfiguration} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see SpeedupWebMvcAutoConfiguration
 * @since 2017.04.11
 */
@ActiveProfiles("enabled")
public class SpeedupWebMvcAutoConfigurationTest extends AbstractSpringBootTest {


    @Test
    public void testNoopOrderedHiddenHttpMethodFilter() throws ServletException, IOException {

        NoopOrderedHiddenHttpMethodFilter filter = applicationContext.getBean(NoopOrderedHiddenHttpMethodFilter.class);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        request.setParameter("_method", "action");

        MockHttpServletResponse response = new MockHttpServletResponse();

        MockFilterChain filterChain = new MockFilterChain();

        filter.doFilter(request, response, filterChain);

        Assert.assertFalse(HttpServletRequestWrapper.class.isAssignableFrom(filterChain.getRequest().getClass()));
        Assert.assertTrue(MockHttpServletRequest.class.isAssignableFrom(filterChain.getRequest().getClass()));

    }

    @Test
    public void testNoopOrderedHttpPutFormContentFilter() throws ServletException, IOException {

        NoopOrderedHttpPutFormContentFilter filter = applicationContext.getBean(NoopOrderedHttpPutFormContentFilter.class);

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("PUT");

        MockHttpServletResponse response = new MockHttpServletResponse();

        MockFilterChain filterChain = new MockFilterChain();

        filter.doFilter(request, response, filterChain);

        Assert.assertFalse(HttpServletRequestWrapper.class.isAssignableFrom(filterChain.getRequest().getClass()));
        Assert.assertTrue(MockHttpServletRequest.class.isAssignableFrom(filterChain.getRequest().getClass()));

    }

}
