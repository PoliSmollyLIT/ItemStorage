package com.example.storage.api.operations.itemStorage.create;

import com.example.storage.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemRequest implements OperationInput {
    @NotBlank
    private UUID item;
    @NotBlank
    private int quantity;
    @NotBlank
    private double price;
}
