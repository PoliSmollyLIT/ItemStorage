package com.example.storage.api.operations.itemStorage.setPrice;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetPriceRequest {
    private UUID id;
    private double price;
}
