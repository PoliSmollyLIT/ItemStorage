package com.example.storage.api.operations.itemStorage.create;

import com.example.storage.api.operations.base.OperationResult;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemResponse implements OperationResult {
    private UUID id;
    private UUID item;
    private int quantity;
    private double price;
}
