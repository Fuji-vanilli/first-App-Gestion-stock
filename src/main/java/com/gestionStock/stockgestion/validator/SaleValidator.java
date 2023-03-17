package com.gestionStock.stockgestion.validator;

import com.gestionStock.stockgestion.DTOs.request.SaleRequest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SaleValidator {

    public static List<String> validate(SaleRequest saleRequest){
        List<String> errors= new ArrayList<>();

        if(saleRequest == null || !StringUtils.hasLength(saleRequest.getCode())){
            errors.add("sale doesn't empty and code sale is required");
        }
        if(saleRequest.getLineSale()== null){
            errors.add("line sale is required!");
        }

        return errors;
    }
}
