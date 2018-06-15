package com.alibaba.boot.web.util;

import com.alibaba.boot.web.filter.NoopOrderedHiddenHttpMethodFilter;
import com.alibaba.boot.web.filter.NoopOrderedHttpPutFormContentFilter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;

/**
 * Web Support Utilities
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since 2017.03.29
 */
public abstract class WebSupportUtils {

    /**
     * The prefix of property name
     */
    public static final String PROPERTY_NAME_PREFIX = "web-support.";

    /**
     * The prefix of property name of {@link ContentNegotiationManager}
     */
    public static final String CONTENT_NEGOTIATION_MANAGER_PROPERTY_NAME_PREFIX = PROPERTY_NAME_PREFIX +
            "content-negotiation-manager";

    /**
     * The property name of exclusive bean name of {@link ViewResolver}s.
     */
    public static final String VIEW_RESOLVERS_EXCLUSIVE_BEAN_NAME_PROPERTY_NAME = PROPERTY_NAME_PREFIX
            + "exclusive-view-resolver";

    /**
     * The property name of class name of {@link NoopOrderedHiddenHttpMethodFilter}
     */
    public static final String NOOP_HIDDEN_HTTP_METHOD_FILTER_ENABLED_PROPERTY_NAME =
            PROPERTY_NAME_PREFIX + "noop.httpmethod.hiddenfilter.enabled";

    /**
     * The property name of class name of {@link NoopOrderedHttpPutFormContentFilter}
     */
    public static final String NOOP_HTTP_PUT_FORM_CONTENT_FILTER_ENABLED_PROPERTY_NAME =
            PROPERTY_NAME_PREFIX + "noop.formcontent.putfilter.enabled";

}
