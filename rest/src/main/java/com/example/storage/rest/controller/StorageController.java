package com.example.storage.rest.controller;

import com.example.storage.api.operations.itemStorage.create.CreateItemRequest;
import com.example.storage.api.operations.itemStorage.get.GetItemRequest;
import com.example.storage.api.operations.itemStorage.getall.GetAllRequest;
import com.example.storage.api.operations.itemStorage.getall.GetAllResponse;
import com.example.storage.api.operations.price.set.SetPriceOperation;
import com.example.storage.api.operations.price.set.SetPriceRequest;
import com.example.storage.api.operations.quantity.export.ExportItemRequest;
import com.example.storage.core.operations.item.CreateItemImpl;
import com.example.storage.core.operations.item.ExportItemImpl;
import com.example.storage.core.operations.item.GetAllItemsImpl;
import com.example.storage.core.operations.item.GetItemImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/storage")
@Tag(name = "Storage", description = "API for working with storage with items")
@RequiredArgsConstructor
public class StorageController {
    private final ExportItemImpl exportItem;
    private final CreateItemImpl createItem;
    private final GetItemImpl getItem;
    private final SetPriceOperation setPrice;
    private final GetAllItemsImpl getAll;
    @PutMapping("/quantity/{id}")
    @Operation(summary = "Create Item in Storage", description = "Creates a new Item into STorage")
    ResponseEntity addItem(@PathVariable UUID item_id, @Valid @RequestBody ExportItemRequest exportItemRequest) {
        return ResponseEntity.ok(exportItem.process(exportItemRequest));
    }

    @PostMapping()
    @Operation(summary = "Create Item in Storage", description = "Creates a new Item into Storage")
    ResponseEntity createItem(@Valid @RequestBody CreateItemRequest createItemRequest){
        return ResponseEntity.ok(createItem.process(createItemRequest));
    }

    @PutMapping("/price/{item_id}")
    @Operation()
    ResponseEntity setPrice(@Valid @PathVariable UUID item_id, @RequestBody double price){
        SetPriceRequest setPriceRequest = SetPriceRequest.builder()
                .id(item_id)
                .price(price)
                .build();
        return ResponseEntity.ok(setPrice.process(setPriceRequest));
    }

    @GetMapping("/{id}")
    ResponseEntity getItem(@PathVariable UUID id){
        GetItemRequest item = GetItemRequest.builder()
                .id(id)
                .build();
        return ResponseEntity.ok(getItem.process(item));
    }

    @PostMapping("/items")
    ResponseEntity getAllItems(@RequestBody GetAllRequest request){
        GetAllRequest requestItems = GetAllRequest.builder()
                .items(request.getItems())
                .build();
        return ResponseEntity.ok(getAll.process(requestItems));
    }
}
