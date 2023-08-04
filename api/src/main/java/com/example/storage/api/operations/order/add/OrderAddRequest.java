package com.example.storage.api.operations.order.add;

import com.example.storage.api.operations.base.OperationInput;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddRequest implements OperationInput {
    private UUID cartID;
    private UUID user;
    private Double price;
    private List<OrderAddOrderItem> items;
}
