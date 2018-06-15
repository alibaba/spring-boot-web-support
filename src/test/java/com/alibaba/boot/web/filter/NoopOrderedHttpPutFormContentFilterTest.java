package com.alibaba.boot.web.filter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;

import static org.springframework.web.filter.OncePerRequestFilter.ALREADY_FILTERED_SUFFIX;

/**
 * {@link NoopOrderedHttpPutFormContentFilter} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see NoopOrderedHttpPutFormContentFilter
 * @since 2017.03.21
 */
public class NoopOrderedHttpPutFormContentFilterTest {

    private static final String FILTER_NAME = "test-filter";

    private static final String FILTERED_ATTRIBUTE_NAME = FILTER_NAME + ALREADY_FILTERED_SUFFIX;

    private MockEnvironment environment = new MockEnvironment();

    private MockFilterConfig filterConfig = new MockFilterConfig(FILTER_NAME);

    private MockHttpServletRequest request = new MockHttpServletRequest();

    private MockHttpServletResponse response = new MockHttpServletResponse();

    private FilterChain filterChain = new MockFilterChain();

    private NoopOrderedHttpPutFormContentFilter filter = new NoopOrderedHttpPutFormContentFilter();

    @Before
    public void init() throws ServletException {

        filter.init(filterConfig);

        filter.setEnvironment(environment);

    }

    @Test
    public void testShouldNotFilter() throws ServletException {

        filter.setEnvironment(environment);

        Assert.assertTrue(filter.shouldNotFilter(request));

    }

    @Test
    public void testOrder() {

        filter.setOrder(1);

        Assert.assertEquals(1, filter.getOrder());

    }


    @Test
    public void testDoFilter() throws ServletException, IOException {


        filter.doFilter(request, response, filterChain);

        Assert.assertNull(request.getAttribute(FILTERED_ATTRIBUTE_NAME));

    }

}
