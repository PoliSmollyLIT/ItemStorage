package com.example.storage.api.operations.itemStorage.exportItem;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemRequest {
    private UUID id;
    private int quantity;

}
