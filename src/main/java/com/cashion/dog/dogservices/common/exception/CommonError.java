package com.cashion.dog.dogservices.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CommonError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<InnerCommonError> errors = new ArrayList<>();

    public void addCommonError(InnerCommonError error) {
        errors.add(error);
    }
}
