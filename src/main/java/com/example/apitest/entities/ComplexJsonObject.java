package com.example.apitest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplexJsonObject {
    private String id;
    private String name;
    private int age;
    private boolean isActive;
    private List<String> tags;
    private Map<String, String> metadata;
}

