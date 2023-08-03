package com.example.storage.api.operations.itemStorage.getall;

import com.example.storage.api.operations.base.OperationProcessor;

public interface GetAllOperation extends OperationProcessor<GetAllResponse, GetAllRequest> {
        GetAllResponse process(GetAllRequest request);
}
