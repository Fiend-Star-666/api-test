package com.example.apitest.services;

import com.example.apitest.entities.ComplexJsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonService {
    private final List<ComplexJsonObject> jsonObjectList = new ArrayList<>();
    @Value("${external.api.url}")
    private String externalApiUrl;

    public void storeJsonObjects(List<ComplexJsonObject> jsonObjects) {
        jsonObjectList.addAll(jsonObjects);
    }

    public ResponseEntity<String> sendDataToExternalApi() {
        if (jsonObjectList.isEmpty()) {
            return ResponseEntity.ok("No JSON objects to send.");
        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(externalApiUrl, jsonObjectList, String.class);
        jsonObjectList.clear();

        return ResponseEntity.ok("External API responded with: " + response.getBody());
    }
}
