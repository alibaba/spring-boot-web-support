package com.alibaba.boot.web.autoconfigure;

import com.alibaba.boot.web.AbstractSpringBootTest;
import com.alibaba.spring.util.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.List;

/**
 * {@link ContentNegotiationManagerConfiguration} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ContentNegotiationManagerConfiguration
 * @since 2017.03.29
 */
@ActiveProfiles("disabled")
public class ContentNegotiationManagerConfigurationDisabledTest extends AbstractSpringBootTest {

    @Autowired
    private ContentNegotiatingViewResolver contentNegotiatingViewResolver;

    @Test
    public void testContentNegotiationManagerConfigurationOnDisabled() {

        Assert.assertFalse(BeanUtils.isBeanPresent(applicationContext, ContentNegotiationManagerConfiguration.class));

        ContentNegotiationManager contentNegotiationManager =
                contentNegotiatingViewResolver.getContentNegotiationManager();

        List<ContentNegotiationStrategy> strategies = contentNegotiationManager.getStrategies();

        Assert.assertEquals(1, strategies.size());
        Assert.assertTrue(contains(HeaderContentNegotiationStrategy.class, strategies));

    }

    private boolean contains(Class<? extends ContentNegotiationStrategy> strategyClass,
                             List<ContentNegotiationStrategy> strategies) {

        boolean contained = false;

        for (ContentNegotiationStrategy strategy : strategies) {

            contained = strategyClass.isInstance(strategy);

            if (contained) {
                break;
            }

        }

        return contained;
    }

}
