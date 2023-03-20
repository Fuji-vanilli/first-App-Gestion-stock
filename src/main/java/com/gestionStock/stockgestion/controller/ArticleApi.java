package com.gestionStock.stockgestion.controller;

import com.gestionStock.stockgestion.DTOs.request.ArticleRequest;
import com.gestionStock.stockgestion.DTOs.response.ArticleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gestionStock.stockgestion.utils.Root.APP_ROOT;

@Api(APP_ROOT+"/article")
public interface ArticleApi {
    @PostMapping("create")
    @ApiOperation(value = "creating a new article", notes = "create and add article")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article created"),
            @ApiResponse(code = 400, message = "article not valid")
    })
    ArticleResponse create(@RequestBody ArticleRequest articleRequest);
    @GetMapping("get/{id}")
    @ApiOperation(value = "getting an article", notes = "getting by id an article")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article get successfuly"),
            @ApiResponse(code = 404, message = "article not found")
    })
    ArticleResponse getById(@PathVariable String id);
    @GetMapping("get/{code}")
    @ApiOperation(value = "getting an article", notes = "getting by code an article")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article get successfuly"),
            @ApiResponse(code = 404, message = "article not found")
    })
    ArticleResponse getByCodeArticle(@PathVariable String code);
    @GetMapping("all")
    @ApiOperation(value = "getting all article", notes = "all article")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article get successfuly"),
            @ApiResponse(code = 404, message = "article not found")
    })
    List<ArticleResponse> getAll();
    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "deleting an article", notes = "deleting by id an article")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "article deleted successfuly"),
            @ApiResponse(code = 400, message = "request not valid")
    })
    boolean deleteById(@PathVariable String id);
}
