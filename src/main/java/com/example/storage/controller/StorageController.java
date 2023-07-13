package com.example.storage.controller;

import com.example.storage.api.operations.itemStorage.createItem.CreateItemRequest;
import com.example.storage.api.operations.itemStorage.exportItem.ExportItemRequest;
import com.example.storage.api.operations.itemStorage.importItem.ImportItemRequest;
import com.example.storage.business.operations.item.CreateItemImpl;
import com.example.storage.business.operations.item.ExportItemImpl;
import com.example.storage.business.operations.item.ImportItemImpl;
import com.example.storage.exceptions.NotEnoughQuantityOfSelectedItemException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
@Tag(name = "Storage", description = "API for working with storage with items")
@RequiredArgsConstructor
public class StorageController {
    private final ImportItemImpl importItem;
    private final ExportItemImpl exportItem;
    private final CreateItemImpl createItem;
    @PostMapping("/import")
    @Operation(summary = "Create Item in Storage", description = "Creates a new Item into STorage")
    ResponseEntity addItem(@RequestBody ImportItemRequest importItemRequest) throws NotEnoughQuantityOfSelectedItemException {
        return ResponseEntity.ok(importItem.importItem(importItemRequest));
    }

    @PostMapping("/sell")
    @Operation(summary = "Sell Item from Storage", description = "Sells an existing Item from Storage")
    ResponseEntity sellItem(@RequestBody ExportItemRequest exportItemRequest) throws NotEnoughQuantityOfSelectedItemException {
        return ResponseEntity.ok(exportItem.sellItem(exportItemRequest));
    }

    @PostMapping("/create")
    @Operation(summary = "Create Item in Storage", description = "Creates a new Item into Storage")
    ResponseEntity createItem(@RequestBody CreateItemRequest createItemRequest){
        return ResponseEntity.ok(createItem.createItem(createItemRequest));
    }
}
