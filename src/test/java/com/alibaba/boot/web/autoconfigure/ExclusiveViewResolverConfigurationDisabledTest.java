package com.alibaba.boot.web.autoconfigure;

import com.alibaba.boot.web.AbstractSpringBootTest;
import com.alibaba.spring.util.BeanUtils;
import com.alibaba.spring.web.context.ExclusiveViewResolverApplicationListener;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.List;

/**
 * {@link ExclusiveViewResolverConfiguration} Disabled Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ExclusiveViewResolverConfiguration
 * @since 2017.03.29
 */
@ActiveProfiles("disabled")
public class ExclusiveViewResolverConfigurationDisabledTest extends AbstractSpringBootTest {

    @Test
    public void testExclusiveViewResolverConfigurationDisabled() {

        Assert.assertFalse(BeanUtils.isBeanPresent(applicationContext, ExclusiveViewResolverConfiguration.class));
        Assert.assertFalse(BeanUtils.isBeanPresent(applicationContext, ExclusiveViewResolverApplicationListener.class));

        ContentNegotiatingViewResolver contentNegotiatingViewResolver =
                applicationContext.getBean(ContentNegotiatingViewResolver.class);

        Assert.assertNotNull(contentNegotiatingViewResolver);

        List<ViewResolver> viewResolvers = contentNegotiatingViewResolver.getViewResolvers();

        Assert.assertTrue(viewResolvers.size() > 1);

        ThymeleafViewResolver thymeleafViewResolver =
                applicationContext.getBean("thymeleafViewResolver", ThymeleafViewResolver.class);

        Assert.assertTrue(viewResolvers.contains(thymeleafViewResolver));

    }
}
