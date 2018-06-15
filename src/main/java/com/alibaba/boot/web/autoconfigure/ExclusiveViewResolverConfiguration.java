package com.alibaba.boot.web.autoconfigure;

import com.alibaba.spring.web.context.ExclusiveViewResolverApplicationListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import static com.alibaba.boot.web.util.WebSupportUtils.VIEW_RESOLVERS_EXCLUSIVE_BEAN_NAME_PROPERTY_NAME;

/**
 * Exclusive {@link ViewResolver} {@link Configuration}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ViewResolver
 * @see Configuration
 * @since 2017.03.23
 */
@ConditionalOnWebApplication
@ConditionalOnProperty(VIEW_RESOLVERS_EXCLUSIVE_BEAN_NAME_PROPERTY_NAME)
public class ExclusiveViewResolverConfiguration {

    @Bean
    public ExclusiveViewResolverApplicationListener exclusiveViewResolverApplicationListener
            (@Value("${" + VIEW_RESOLVERS_EXCLUSIVE_BEAN_NAME_PROPERTY_NAME + "}") String exclusiveViewResolverBeanName) {

        ExclusiveViewResolverApplicationListener applicationListener =
                new ExclusiveViewResolverApplicationListener(exclusiveViewResolverBeanName);

        return applicationListener;

    }

}
