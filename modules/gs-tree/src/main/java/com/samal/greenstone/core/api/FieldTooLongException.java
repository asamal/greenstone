package com.samal.greenstone.core.api;

public class FieldTooLongException extends RuntimeException {
    public FieldTooLongException(String fieldName, int length) {
        super(String.format("%s length should be less than %d", fieldName, length));
    }
}
