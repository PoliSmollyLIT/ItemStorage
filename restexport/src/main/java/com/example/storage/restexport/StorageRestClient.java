package com.example.storage.restexport;

import com.example.storage.api.operations.itemStorage.create.CreateItemRequest;
import com.example.storage.api.operations.itemStorage.create.CreateItemResponse;
import com.example.storage.api.operations.itemStorage.get.GetItemResponse;
import com.example.storage.api.operations.price.set.SetPriceRequest;
import com.example.storage.api.operations.price.set.SetPriceResponse;
import com.example.storage.api.operations.quantity.export.ExportItemRequest;
import com.example.storage.api.operations.quantity.export.ExportItemResponse;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface StorageRestClient {
    @RequestLine("GET /storage/{id}")
    GetItemResponse getItemById(@Param String id);

    @RequestLine("PUT /storage/quantity/{id}")
    ExportItemResponse editItemQuantity(@Param String id, ExportItemRequest input);

    @RequestLine("POST /storage")
    CreateItemResponse createItem(CreateItemRequest input);

    @RequestLine("PUT /storage/price/{item_id}")
    SetPriceResponse setPrice(SetPriceRequest input);
}
