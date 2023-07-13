package com.example.storage.api.operations.itemStorage.setPrice;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetPriceResponse {
    private UUID id;
    private UUID item;
    private int quantity;
    private double price;
}
