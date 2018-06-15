package com.alibaba.boot.web.filter;

import org.springframework.core.Ordered;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * {@link Ordered} No-Operation {@link HiddenHttpMethodFilter}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see HiddenHttpMethodFilter
 * @since 2017.03.21
 */
public final class NoopOrderedHiddenHttpMethodFilter extends HiddenHttpMethodFilter implements Ordered {

    private int order = -10000;

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
