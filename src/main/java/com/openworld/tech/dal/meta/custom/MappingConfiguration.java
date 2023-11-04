package com.openworld.tech.dal.meta.custom;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

@Component
public class MappingConfiguration {

    private final Map<String, Map<String, String>> entityToTableMappings = new HashMap<>();

    public MappingConfiguration() {
        loadMappingConfig();
    }

    public boolean containsEntityMapping(String entityName) {
        return entityToTableMappings.containsKey(entityName);
    }

    public Map<String, String> getEntityAttributeToColumnMapping(String entityName) {
        return entityToTableMappings.get(entityName);
    }

    private void loadMappingConfig() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonMappingConfig = loadMappingConfigString();
            JsonNode rootNode = objectMapper.readTree(jsonMappingConfig);

            JsonNode entityToTableMappingNode = rootNode.get("domainToTableMapping");
            entityToTableMappingNode.fields().forEachRemaining(entry -> {
                String entityName = entry.getKey();
                Map<String, String> attributeToColumnMapping = new HashMap<>();
                JsonNode fieldsNode = entry.getValue().get("fields");
                fieldsNode.fields().forEachRemaining(fieldEntry -> {
                    attributeToColumnMapping.put(fieldEntry.getKey(), fieldEntry.getValue().get("columnName").asText());
                });
                entityToTableMappings.put(entityName, attributeToColumnMapping);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to load the JSON mapping configuration (e.g., from a file or resource)
    private String loadMappingConfigString() {
        // Implement your logic to load the JSON mapping configuration here
        // Example: Read the JSON from a file, resource, or a database
        // Return the JSON content as a string

        String jsonMappingConfig = null;
        ClassPathResource resource = new ClassPathResource("DomainToTableMapping.json");
        try {
            InputStream inputStream = resource.getInputStream();
            Path tempFile =
                    Files.createTempDirectory("").resolve(UUID.randomUUID().toString() + ".tmp");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            jsonMappingConfig = new String(Files.readAllBytes(tempFile));

        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonMappingConfig;
    }
}



