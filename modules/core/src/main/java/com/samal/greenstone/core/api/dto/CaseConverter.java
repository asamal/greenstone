package com.samal.greenstone.core.api.dto;

import org.springframework.stereotype.Component;

@Component
public class CaseConverter {
    @LowerCase
    public String toLowerCase(String input) {
        return input.toLowerCase();
    }

    @UpperCase
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }
}
