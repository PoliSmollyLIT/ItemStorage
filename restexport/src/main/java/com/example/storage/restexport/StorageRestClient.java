package com.example.storage.restexport;

import com.example.storage.api.operations.itemStorage.get.GetItemResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface StorageRestClient {
    @RequestLine("GET /storage/{id}")
    GetItemResponse getItemById(@Param String id);
}
