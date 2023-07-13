package com.example.storage.api.operations.itemStorage.importItem;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemRequest {
    private UUID id;
    private int quantity;
}
