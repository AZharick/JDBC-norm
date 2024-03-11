package com.example.jdbc0.controller;

import com.example.jdbc0.service.DBService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/products/fetch-product")
public class RequestProductController {
    private final DBService service;

    public RequestProductController(DBService service) {
        this.service = service;
    }

    @GetMapping
    public String getProductName(String name) throws SQLException {
        return service.getProductName(name);
    }

}