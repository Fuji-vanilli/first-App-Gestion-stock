package com.gestionStock.stockgestion.handlers;

import com.gestionStock.stockgestion.exceptions.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {

    private ErrorCode code;
    private Integer statusCode;
    private String message;
    private List<String> errors;

}
