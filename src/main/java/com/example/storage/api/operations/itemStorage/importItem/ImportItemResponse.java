package com.example.storage.api.operations.itemStorage.importItem;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemResponse {
    private UUID id;
    private UUID item;
    private int quantity;
    private double price;
}
