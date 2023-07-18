package com.example.storage.api.operations.itemStorage.create;

import com.example.storage.api.operations.base.OperationResult;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemResponse implements OperationResult {
    @NotBlank
    private UUID id;
    @NotBlank
    private UUID item;
    @NotBlank
    private int quantity;
    @NotBlank
    private double price;
}
