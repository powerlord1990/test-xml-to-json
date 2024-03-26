package ru.inovus.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.inovus.service.XMLToJsonService;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class XMLToJsonServiceImpl implements XMLToJsonService {

    private final XmlMapper xmlMapper;

    public String convertXmlToJson(MultipartFile file) throws IOException {
        try {
            JsonNode xmlNode = xmlMapper.readTree(file.getInputStream());
            return xmlNode.toString();
        } catch (IOException e) {
            log.error("Error reading input stream", e);
            throw e;
        }
    }
}
