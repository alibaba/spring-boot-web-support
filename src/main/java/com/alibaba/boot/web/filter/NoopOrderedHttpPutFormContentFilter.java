package com.alibaba.boot.web.filter;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.HttpPutFormContentFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * {@link Ordered} No-Operation {@link HttpPutFormContentFilter}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see HttpPutFormContentFilter
 * @see WebMvcAutoConfiguration#httpPutFormContentFilter()
 * @since 2017.03.21
 */
public final class NoopOrderedHttpPutFormContentFilter extends HttpPutFormContentFilter implements Ordered {

    private int order = -9900;

    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

        return true;

    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

}
