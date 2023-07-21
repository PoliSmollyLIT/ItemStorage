package com.example.storage.domain.client;

import com.example.zooostore.restexport.ZooStoreRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Contract;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

@Configuration
@RequiredArgsConstructor
public class ZooStoreClientConfiguration {
     @Bean
     ZooStoreRestClient getRestExportClient() {
            final ObjectMapper objectMapper = new ObjectMapper();
            return Feign.builder()
                    .encoder(new JacksonEncoder(objectMapper))
                    .decoder(new JacksonDecoder(objectMapper))
                    .target(ZooStoreRestClient.class, "http://localhost:8080");
        }
}
