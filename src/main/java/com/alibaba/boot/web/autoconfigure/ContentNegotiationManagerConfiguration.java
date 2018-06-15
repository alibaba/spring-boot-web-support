package com.alibaba.boot.web.autoconfigure;

import com.alibaba.boot.web.condition.ConditionalOnPropertyPrefix;
import com.alibaba.spring.util.PropertySourcesUtils;
import com.alibaba.spring.web.servlet.config.annotation.ConfigurableContentNegotiationManagerWebMvcConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

import static com.alibaba.boot.web.util.WebSupportUtils.CONTENT_NEGOTIATION_MANAGER_PROPERTY_NAME_PREFIX;

/**
 * {@link ContentNegotiationManager} {@link Configuration}
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ContentNegotiationManager
 * @since 2017.03.29
 */

@ConditionalOnWebApplication
@ConditionalOnBean(WebMvcConfigurationSupport.class)
@ConditionalOnPropertyPrefix({CONTENT_NEGOTIATION_MANAGER_PROPERTY_NAME_PREFIX})
@AutoConfigureAfter(name = {
        "org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration",         // compatible with Spring Boot 1.x
        "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration"  // compatible with Spring Boot 2.0
})
public class ContentNegotiationManagerConfiguration {

    @Bean
    public WebMvcConfigurer configurableContentNegotiationManagerWebMvcConfigurer(ConfigurableEnvironment environment) {

        Map<String, String> properties = new HashMap<String, String>();

        Map<String, Object> subProperties = PropertySourcesUtils.getSubProperties(environment.getPropertySources(),
                CONTENT_NEGOTIATION_MANAGER_PROPERTY_NAME_PREFIX);

        for (Map.Entry<String, Object> entry : subProperties.entrySet()) {
            properties.put(entry.getKey(), entry.getValue().toString());
        }

        return new ConfigurableContentNegotiationManagerWebMvcConfigurer(properties);

    }


}
