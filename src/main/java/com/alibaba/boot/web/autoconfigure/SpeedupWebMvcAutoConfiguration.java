package com.alibaba.boot.web.autoconfigure;

import com.alibaba.boot.web.filter.NoopOrderedHiddenHttpMethodFilter;
import com.alibaba.boot.web.filter.NoopOrderedHttpPutFormContentFilter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Servlet;

import static com.alibaba.boot.web.util.WebSupportUtils.NOOP_HIDDEN_HTTP_METHOD_FILTER_ENABLED_PROPERTY_NAME;
import static com.alibaba.boot.web.util.WebSupportUtils.NOOP_HTTP_PUT_FORM_CONTENT_FILTER_ENABLED_PROPERTY_NAME;

/**
 * Speed up {@link WebMvcAutoConfiguration} , auto configure before {@link WebMvcAutoConfiguration} and
 * after {@link DispatcherServletAutoConfiguration} , which speeds up execution time and improves performances.
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see WebMvcAutoConfiguration
 * @see DispatcherServletAutoConfiguration
 * @since 2017.04.11
 */
@ConditionalOnWebApplication
@ConditionalOnClass({Servlet.class, DispatcherServlet.class,
        WebMvcConfigurerAdapter.class})
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
@AutoConfigureBefore(name = {
        "org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration",         // compatible with Spring Boot 1.x
        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration"  // compatible with Spring Boot 2.0
})
@AutoConfigureAfter(name = {
        "org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration", // compatible with Spring Boot 1.x
        "org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration" // compatible with Spring Boot 2.0
})
public class SpeedupWebMvcAutoConfiguration {

    @Bean
    @ConditionalOnProperty(value = NOOP_HIDDEN_HTTP_METHOD_FILTER_ENABLED_PROPERTY_NAME, havingValue = "true")
    @ConditionalOnMissingBean(HiddenHttpMethodFilter.class)
    public NoopOrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new NoopOrderedHiddenHttpMethodFilter();
    }

    /**
     * spring.mvc.formcontent.putfilter property since 1.4.1.RELEASE
     */
    @Bean
    @ConditionalOnProperty(value = {NOOP_HTTP_PUT_FORM_CONTENT_FILTER_ENABLED_PROPERTY_NAME}, havingValue = "true")
    @ConditionalOnMissingBean(HttpPutFormContentFilter.class)
    public NoopOrderedHttpPutFormContentFilter httpPutFormContentFilter() {
        return new NoopOrderedHttpPutFormContentFilter();
    }

}
