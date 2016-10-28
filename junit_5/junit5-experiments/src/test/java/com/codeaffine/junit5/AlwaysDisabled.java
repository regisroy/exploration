package com.codeaffine.junit5;

@SuppressWarnings("WeakerAccess")
public class AlwaysDisabled implements DisabledWhenCondition {

    @Override
    public boolean isSatisfied() {
        return true;
    }
}