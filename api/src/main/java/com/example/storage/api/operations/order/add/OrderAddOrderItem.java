package com.example.storage.api.operations.order.add;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddOrderItem {
    private UUID id;
    private Integer quantity;
    private Double price;
}
