package com.gestionStock.stockgestion.handlers;

import com.gestionStock.stockgestion.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpcode;

    private ErrorCode errorCode;

    private String message;

    private List<String> errors = new ArrayList<String>();
}