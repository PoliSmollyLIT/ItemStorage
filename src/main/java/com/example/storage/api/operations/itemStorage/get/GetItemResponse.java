package com.example.storage.api.operations.itemStorage.get;

import com.example.storage.api.operations.base.OperationResult;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetItemResponse implements OperationResult {
    private UUID id;
    private UUID item;
    private int quantity;
    private double price;
}
