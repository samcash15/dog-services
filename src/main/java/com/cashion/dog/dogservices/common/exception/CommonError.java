package com.cashion.dog.dogservices.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class CommonError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InnerCommonError> errors = new ArrayList<>();

    public void addCommonError(InnerCommonError error) {
        errors.add(error);
    }
}
