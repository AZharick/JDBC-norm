package com.example.jdbc0.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DBAccessRepository {
    private String script;
    private NamedParameterJdbcTemplate npt;

    public DBAccessRepository(NamedParameterJdbcTemplate npt) {
        this.script = readScript();
        this.npt = npt;
    }

    public String getProductName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        List<String> result = npt.queryForList(script, params, String.class);
        return result.toString();
    }

    private static String readScript() {
        try (InputStream is = new ClassPathResource("myScript.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}