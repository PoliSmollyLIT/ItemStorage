package com.example.storage.api.operations.price.set;

import com.example.storage.api.operations.base.OperationProcessor;

public interface SetPriceOperation extends OperationProcessor<SetPriceResponse, SetPriceRequest> {
    SetPriceResponse process(SetPriceRequest setPriceRequest);
}
