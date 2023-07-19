package com.example.storage.api.operations.quantity.importItem;

import com.example.storage.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemRequest implements OperationInput {
    @NotBlank
    private UUID id;
    @NotBlank
    private int quantity;
}
