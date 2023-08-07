package com.example.storage.rest.controller;

import com.example.storage.api.operations.itemStorage.create.CreateItemOperation;
import com.example.storage.api.operations.itemStorage.create.CreateItemRequest;
import com.example.storage.api.operations.itemStorage.get.GetItemOperation;
import com.example.storage.api.operations.itemStorage.get.GetItemRequest;
import com.example.storage.api.operations.itemStorage.getall.GetAllOperation;
import com.example.storage.api.operations.itemStorage.getall.GetAllRequest;
import com.example.storage.api.operations.order.add.OrderAddOpeartion;
import com.example.storage.api.operations.order.add.OrderAddRequest;
import com.example.storage.api.operations.order.add.OrderAddResponse;
import com.example.storage.api.operations.price.set.SetPriceOperation;
import com.example.storage.api.operations.price.set.SetPriceRequest;
import com.example.storage.api.operations.quantity.export.ExportItemOperation;
import com.example.storage.api.operations.quantity.export.ExportItemRequest;
import com.example.storage.core.operations.item.CreateItemCore;
import com.example.storage.core.operations.item.ExportItemCore;
import com.example.storage.core.operations.item.GetAllItemsCore;
import com.example.storage.core.operations.item.GetItemCore;
import com.example.zooostore.api.operations.item.getall.GetAllItemsOperation;
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
    private final ExportItemOperation exportItem;
    private final CreateItemOperation createItem;
    private final GetItemOperation getItem;
    private final SetPriceOperation setPrice;
    private final GetAllOperation getAll;
    private final OrderAddOpeartion orderAdd;
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

    @PostMapping("/order")
    ResponseEntity<OrderAddResponse> orderAdd(@RequestBody OrderAddRequest request){
        OrderAddResponse process = orderAdd.process(request);
        return ResponseEntity.ok(process);
    }
}
