package com.gestionStock.stockgestion.DTOs.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    private String code;

    private String designation;

    @JsonIgnore
    private List<ArticleResponse> articles;

}
