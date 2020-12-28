package com.samal.greenstone.core.api;

public class FieldTooShortException extends RuntimeException {
    public FieldTooShortException(String fieldName, int length) {
        super(String.format("%s length should be more than %d", fieldName, length));
    }
}
