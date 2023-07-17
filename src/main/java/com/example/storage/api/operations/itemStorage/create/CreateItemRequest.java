package com.example.storage.api.operations.itemStorage.create;

import com.example.storage.api.operations.base.OperationInput;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemRequest implements OperationInput {
    private UUID item;
    private int quantity;
    private double price;
}
