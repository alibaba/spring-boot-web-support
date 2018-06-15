package com.alibaba.boot.web.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@link Conditional} that checks if the prefix of properties are found in environment..
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see OnPropertyPrefixCondition
 * @since 2017.03.29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnPropertyPrefixCondition.class)
public @interface ConditionalOnPropertyPrefix {

    /**
     * The prefix values of properties.
     * <p>
     * The prefix automatically ends
     * with a dot if not specified.
     *
     * @return prefix values of properties.
     */
    String[] value();

}
