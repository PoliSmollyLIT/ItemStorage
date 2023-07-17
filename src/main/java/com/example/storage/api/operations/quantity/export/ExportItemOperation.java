package com.example.storage.api.operations.quantity.export;

import com.example.storage.api.operations.base.OperationProcessor;

public interface ExportItemOperation extends OperationProcessor<ExportItemResponse, ExportItemRequest> {
    ExportItemResponse process(ExportItemRequest exportItemRequest);
}
