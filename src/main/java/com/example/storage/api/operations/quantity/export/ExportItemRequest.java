package com.example.storage.api.operations.quantity.export;

import com.example.storage.api.operations.base.OperationInput;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemRequest implements OperationInput {
    private UUID id;
    private int quantity;

}
