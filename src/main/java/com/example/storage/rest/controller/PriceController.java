package com.example.storage.rest.controller;

import com.example.storage.api.operations.price.set.SetPriceOperation;
import com.example.storage.api.operations.price.set.SetPriceRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
@Tag(name = "Price", description = "API for working with prices for items into storage")
public class PriceController {
    private final SetPriceOperation setPrice;

    @PostMapping("/set/{item_id}")
    @Operation()
    ResponseEntity setPrice(@PathVariable UUID item_id, @RequestBody double price){
        SetPriceRequest setPriceRequest = SetPriceRequest.builder()
                .id(item_id)
                .price(price)
                .build();
        return ResponseEntity.ok(setPrice.process(setPriceRequest));
    }
}
