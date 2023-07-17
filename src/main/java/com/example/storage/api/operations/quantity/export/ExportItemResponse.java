package com.example.storage.api.operations.quantity.export;

import com.example.storage.api.operations.base.OperationResult;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemResponse implements OperationResult {
    private UUID id;
    private UUID item;
    private int quantity;
    private double price;
}
