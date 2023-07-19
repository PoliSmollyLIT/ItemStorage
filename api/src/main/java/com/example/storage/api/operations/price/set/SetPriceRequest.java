package com.example.storage.api.operations.price.set;

import com.example.storage.api.operations.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetPriceRequest implements OperationInput {
    @NotBlank
    private UUID id;
    @NotBlank
    private double price;
}
