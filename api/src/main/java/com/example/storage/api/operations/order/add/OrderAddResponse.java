package com.example.storage.api.operations.order.add;

import com.example.storage.api.operations.base.OperationResult;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddResponse implements OperationResult {
    private String result;
}
