package com.alibaba.boot.web.util;

import org.junit.Assert;
import org.junit.Test;

import static com.alibaba.boot.web.util.ViewResolverUtils.*;

/**
 * {@link ViewResolverUtils} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ViewResolverUtils
 * @since 2017.04.11
 */
public class ViewResolverUtilsTest {

    @Test
    public void testConstants() {

        Assert.assertEquals("defaultViewResolver", INTERNAL_RESOURCE_VIEW_RESOLVER_BEAN_NAME);
        Assert.assertEquals("velocityViewResolver", VELOCITY_VIEW_RESOLVER_BEAN_NAME);
        Assert.assertEquals("thymeleafViewResolver", THYMELEAF_VIEW_RESOLVER_BEAN_NAME);
        Assert.assertEquals("freeMarkerViewResolver", FREEMARKER_VIEW_RESOLVER_BEAN_NAME);
        Assert.assertEquals("groovyMarkupViewResolver", GROOVY_MARKUP_VIEW_RESOLVER_BEAN_NAME);
        Assert.assertEquals("mustacheViewResolver", MUSTACHE_VIEW_RESOLVER_BEAN_NAME);

    }

}
