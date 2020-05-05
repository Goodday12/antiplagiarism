package com.development5053.antiplagiarism.util.webUtil;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ValidationResponse {

    private String statusCode;
    private List<String> descriptions;

}
