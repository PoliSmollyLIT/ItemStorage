package com.example.storage.api.operations.itemStorage.get;

import com.example.storage.api.operations.base.OperationProcessor;

public interface GetItemOperation extends OperationProcessor<GetItemResponse, GetItemRequest> {
    GetItemResponse process(GetItemRequest getItemRequest);
}
