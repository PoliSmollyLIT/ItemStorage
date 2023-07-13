package com.example.storage.api.operations.itemStorage.exportItem;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemResponse {
    private UUID id;
    private UUID item;
    private int quantity;
    private double price;
}
