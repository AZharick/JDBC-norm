package com.example.jdbc0.service;

import com.example.jdbc0.repository.DBAccessRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DBService {
    private final DBAccessRepository repository;

    public DBService(DBAccessRepository repository) {
        this.repository = repository;
    }

    public String getProductName(String name) throws SQLException {
        return repository.getProductName(name);
    }
}