package com.cashion.dog.dogservices.common.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InnerCommonError {
    private String code;
    private String locale;
    private String localizedMessage;
    private List<String> paths;
    private String severity;
    private String supportInformation;
}
