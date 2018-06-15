package com.alibaba.boot.web.util;

import org.springframework.web.servlet.ViewResolver;

/**
 * {@link ViewResolver} Utilities
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ViewResolver
 * @since 2017.03.22
 */
public class ViewResolverUtils {

    /**
     * The bean name of InternalResourceViewResolver
     */
    public static final String INTERNAL_RESOURCE_VIEW_RESOLVER_BEAN_NAME = "defaultViewResolver";

    /**
     * The bean name of org.springframework.web.servlet.view.velocity.VelocityViewResolver
     */
    public static final String VELOCITY_VIEW_RESOLVER_BEAN_NAME = "velocityViewResolver";

    /**
     * The bean name of org.thymeleaf.spring5.view.ThymeleafViewResolver
     */
    public static final String THYMELEAF_VIEW_RESOLVER_BEAN_NAME = "thymeleafViewResolver";

    /**
     * The bean name of org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver
     */
    public static final String FREEMARKER_VIEW_RESOLVER_BEAN_NAME = "freeMarkerViewResolver";

    /**
     * The bean name of org.springframework.web.servlet.view.groovy.GroovyMarkupViewResolver
     */
    public static final String GROOVY_MARKUP_VIEW_RESOLVER_BEAN_NAME = "groovyMarkupViewResolver";

    /**
     * The bean name of org.springframework.boot.web.servlet.view.MustacheViewResolver
     */
    public static final String MUSTACHE_VIEW_RESOLVER_BEAN_NAME = "mustacheViewResolver";


}
