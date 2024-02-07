package com.cashion.dog.dogservices.common.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class CommonErrorBuilder {
    public static final String DEFAULT_LOCALE_ENG_USA = "eng-USA";
    public static final String ERROR = "ERROR";
    public static final String DATA_NOT_RECEIVED = "Data not received";

    public static CommonError fromBindingErrors(Errors errors) {
        CommonError error = new CommonError();
        for (FieldError fieldError : errors.getFieldErrors()) {
            if (fieldError == null) continue;
            String[] retCodes = fieldError.getCodes();

            List<String> codes = retCodes == null ? new ArrayList<>() : Arrays.asList(retCodes);
            String code = "";

            if (codes.contains("NotBlank") || codes.contains("NotEmpty")) {
                code = "DOG000E";
            } else if (codes.contains("Max") || codes.contains("Size")) {
                code = "DOG001E";
            }

            error.addCommonError(InnerCommonError.builder()
                    .code(code)
                    .locale(DEFAULT_LOCALE_ENG_USA)
                    .localizedMessage(fieldError.getDefaultMessage())
                    .paths(Collections.singletonList("/" + fieldError.getField()))
                    .severity(ERROR)
                    .supportInformation(DATA_NOT_RECEIVED)
                    .build());
        }
        return error;
    }
}
