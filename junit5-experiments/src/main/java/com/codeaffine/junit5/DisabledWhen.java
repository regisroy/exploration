package com.codeaffine.junit5;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@SuppressWarnings("WeakerAccess")

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DisabledWhenExtension.class)
public @interface DisabledWhen {

    Class<? extends DisabledWhenCondition> value();
}
