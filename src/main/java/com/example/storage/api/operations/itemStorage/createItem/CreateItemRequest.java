package com.example.storage.api.operations.itemStorage.createItem;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemRequest {
    private UUID item;
    private int quantity;
    private double price;
}