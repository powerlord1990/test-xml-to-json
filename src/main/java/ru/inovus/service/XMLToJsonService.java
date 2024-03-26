package ru.inovus.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface XMLToJsonService {
    String convertXmlToJson(MultipartFile file) throws IOException;
}
