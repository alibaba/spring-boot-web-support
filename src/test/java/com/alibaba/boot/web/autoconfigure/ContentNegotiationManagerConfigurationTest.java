package com.alibaba.boot.web.autoconfigure;

import com.alibaba.boot.web.AbstractSpringBootTest;
import com.alibaba.spring.util.FieldUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.accept.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.List;
import java.util.Map;

/**
 * {@link ContentNegotiationManagerConfiguration} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see ContentNegotiationManagerConfiguration
 * @since 2017.03.29
 */
@ActiveProfiles("enabled")
public class ContentNegotiationManagerConfigurationTest extends AbstractSpringBootTest {

    @Autowired
    private ContentNegotiationManagerConfiguration contentNegotiationManagerConfiguration;

    @Autowired
    private ContentNegotiatingViewResolver contentNegotiatingViewResolver;

    /**
     * spring.web-support.content-negotiation-manager.favorPathExtension = true
     * spring.web-support.content-negotiation-manager.favorParameter = true
     * spring.web-support.content-negotiation-manager.ignoreAcceptHeader = false
     * spring.web-support.content-negotiation-manager.useJaf = false
     * spring.web-support.content-negotiation-manager.parameterName = test-format
     * spring.web-support.content-negotiation-manager.mediaTypes.html = text/html
     * spring.web-support.content-negotiation-manager.mediaTypes.xml = text/xml
     * spring.web-support.content-negotiation-manager.mediaTypes.json = application/json
     * spring.web-support.content-negotiation-manager.mediaTypes.gif = image/gif
     * spring.web-support.content-negotiation-manager.mediaTypes.jpeg = image/jpeg
     * spring.web-support.content-negotiation-manager.defaultContentType = text/html
     */
    @Test
    public void testContentNegotiationManagerConfiguration() {

        ContentNegotiationManager contentNegotiationManager =
                contentNegotiatingViewResolver.getContentNegotiationManager();

        List<ContentNegotiationStrategy> strategies = contentNegotiationManager.getStrategies();

        Assert.assertEquals(4, strategies.size());
        Assert.assertTrue(contains(ParameterContentNegotiationStrategy.class, strategies));
        Assert.assertTrue(contains(HeaderContentNegotiationStrategy.class, strategies));
        Assert.assertTrue(contains(FixedContentNegotiationStrategy.class, strategies));

        ContentNegotiationStrategy strategy = strategies.get(0);

        strategy = FieldUtils.getFieldValue(strategy, "delegate");

        Map<String, MediaType> mediaTypesMap = FieldUtils.getFieldValue(strategy, "mediaTypes");

        Assert.assertEquals("html", mediaTypesMap.get("html").getSubtype());
        Assert.assertEquals("xml", mediaTypesMap.get("xml").getSubtype());
        Assert.assertEquals("json", mediaTypesMap.get("json").getSubtype());
        Assert.assertEquals("gif", mediaTypesMap.get("gif").getSubtype());
        Assert.assertEquals("jpeg", mediaTypesMap.get("jpeg").getSubtype());

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
