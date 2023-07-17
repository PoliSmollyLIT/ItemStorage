package com.example.storage.api.operations.itemStorage.create;

import com.example.storage.api.operations.base.OperationProcessor;

public interface CreateItemOperation extends OperationProcessor<CreateItemResponse, CreateItemRequest> {
    CreateItemResponse process(CreateItemRequest createItemRequest);
}
