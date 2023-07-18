package com.example.storage.rest.controller;

import com.example.storage.api.operations.itemStorage.create.CreateItemRequest;
import com.example.storage.api.operations.itemStorage.get.GetItemRequest;
import com.example.storage.api.operations.quantity.export.ExportItemRequest;
import com.example.storage.api.operations.quantity.importItem.ImportItemRequest;
import com.example.storage.core.operations.item.CreateItemImpl;
import com.example.storage.core.operations.item.ExportItemImpl;
import com.example.storage.core.operations.item.GetItemImpl;
import com.example.storage.core.operations.item.ImportItemImpl;
import com.example.storage.exceptions.NotEnoughQuantityOfSelectedItemException;
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
    private final ImportItemImpl importItem;
    private final ExportItemImpl exportItem;
    private final CreateItemImpl createItem;
    private final GetItemImpl getItem;
    @PostMapping("/import")
    @Operation(summary = "Create Item in Storage", description = "Creates a new Item into STorage")
    ResponseEntity addItem(@Valid @RequestBody ImportItemRequest importItemRequest) throws NotEnoughQuantityOfSelectedItemException {
        return ResponseEntity.ok(importItem.process(importItemRequest));
    }

    @PostMapping("/sell")
    @Operation(summary = "Sell Item from Storage", description = "Sells an existing Item from Storage")
    ResponseEntity sellItem(@Valid @RequestBody ExportItemRequest exportItemRequest) throws NotEnoughQuantityOfSelectedItemException {
        return ResponseEntity.ok(exportItem.process(exportItemRequest));
    }

    @PostMapping("/create")
    @Operation(summary = "Create Item in Storage", description = "Creates a new Item into Storage")
    ResponseEntity createItem(@Valid @RequestBody CreateItemRequest createItemRequest){
        return ResponseEntity.ok(createItem.process(createItemRequest));
    }

    @GetMapping("/get/{id}")
    ResponseEntity getItem(@RequestParam UUID id){
        GetItemRequest item = GetItemRequest.builder()
                .id(id)
                .build();
        return ResponseEntity.ok(getItem.process(item));
    }
}
