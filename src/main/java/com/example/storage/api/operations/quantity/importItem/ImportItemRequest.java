package com.example.storage.api.operations.quantity.importItem;

import com.example.storage.api.operations.base.OperationInput;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemRequest implements OperationInput {
    private UUID id;
    private int quantity;
}
