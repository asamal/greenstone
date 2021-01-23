package com.samal.greenstone.core.api.dto;

import org.springframework.stereotype.Component;

@Component
public class CaseConverter {
    @LowerCase
    public String toLowerCase(String input) {
        if (input == null)
            return null;
        return input.toLowerCase();
    }

    @UpperCase
    public String toUpperCase(String input) {
        if (input == null)
            return null;
        return input.toUpperCase();
    }
}
