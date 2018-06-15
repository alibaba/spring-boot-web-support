package com.alibaba.boot.web.util;

import org.junit.Assert;
import org.junit.Test;

import static com.alibaba.boot.web.util.WebSupportUtils.*;

/**
 * {@link WebSupportUtils} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see WebSupportUtils
 * @since 2017.04.11
 */
public class WebSupportUtilsTest {

    @Test
    public void testConstants() {
        Assert.assertEquals("web-support.", PROPERTY_NAME_PREFIX);

        Assert.assertEquals("web-support.content-negotiation-manager",
                CONTENT_NEGOTIATION_MANAGER_PROPERTY_NAME_PREFIX);

        Assert.assertEquals("web-support.exclusive-view-resolver",
                VIEW_RESOLVERS_EXCLUSIVE_BEAN_NAME_PROPERTY_NAME);

        Assert.assertEquals("web-support.noop.httpmethod.hiddenfilter.enabled",
                NOOP_HIDDEN_HTTP_METHOD_FILTER_ENABLED_PROPERTY_NAME);

        Assert.assertEquals("web-support.noop.formcontent.putfilter.enabled",
                NOOP_HTTP_PUT_FORM_CONTENT_FILTER_ENABLED_PROPERTY_NAME);

    }
}
