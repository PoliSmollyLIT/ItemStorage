package com.example.storage.api.operations.quantity.export;

import com.example.storage.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemRequest implements OperationInput {
    @NotBlank
    private UUID id;
    @NotBlank
    private int quantity;

}
