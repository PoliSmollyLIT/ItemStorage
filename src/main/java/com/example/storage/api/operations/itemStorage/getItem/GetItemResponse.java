package com.example.storage.api.operations.itemStorage.getItem;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetItemResponse {
    private UUID id;
    private UUID item;
    private int quantity;
    private double price;
}
