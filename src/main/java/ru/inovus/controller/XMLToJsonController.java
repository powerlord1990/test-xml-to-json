package ru.inovus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.inovus.service.XMLToJsonService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class XMLToJsonController {
    private final XMLToJsonService xmlToJsonService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) { return ResponseEntity.badRequest().body(createErrorResponse("File is empty"));}

        try {
            String jsonResult = xmlToJsonService.convertXmlToJson(file);
            return ResponseEntity.ok().body(createSuccessResponse(jsonResult));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createErrorResponse("Error processing file"));
        }
    }

    private Map<String, Object> createSuccessResponse(String jsonResult) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("result", jsonResult);
        return response;
    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", message);
        return response;
    }

}