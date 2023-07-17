package com.example.storage.api.operations.price.set;

import com.example.storage.api.operations.base.OperationInput;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetPriceRequest implements OperationInput {
    private UUID id;
    private double price;
}
