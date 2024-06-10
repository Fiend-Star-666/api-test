package com.example.apitest.controllers;


import com.example.apitest.entities.ComplexJsonObject;
import com.example.apitest.services.JsonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/json")
public class JsonController {

    private final JsonService jsonService;

    public JsonController(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    // Way 1: Store and send JSON objects
    @PostMapping("/storeAndSendData")
    public ResponseEntity<String> storeAndSendJsonObjects(@RequestBody List<ComplexJsonObject> jsonObjects) {
        jsonService.storeJsonObjects(jsonObjects);
        return jsonService.sendDataToExternalApi();
    }

    // Way 2: Part 1 -> Store JSON objects in memory
    @PostMapping("/storeDataToMemory")
    public ResponseEntity<String> storeJsonObjectsInMemory(@RequestBody List<ComplexJsonObject> jsonObjects) {
        jsonService.storeJsonObjects(jsonObjects);
        return ResponseEntity.ok("JSON objects stored successfully.");
    }

    // Way 2: Part 2 -> Then Send JSON objects to external API
    @PostMapping("/sendDataToExternalApi")
    public ResponseEntity<String> sendDataToExternalApi() {
        return jsonService.sendDataToExternalApi();
    }

}
