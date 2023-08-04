package com.example.storage.api.operations.order.add;

import com.example.storage.api.operations.base.OperationProcessor;

public interface OrderAddOpeartion extends OperationProcessor<OrderAddResponse, OrderAddRequest> {
    OrderAddResponse process(OrderAddRequest request);
}
