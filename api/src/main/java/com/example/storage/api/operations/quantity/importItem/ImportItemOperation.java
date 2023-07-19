package com.example.storage.api.operations.quantity.importItem;

import com.example.storage.api.operations.base.OperationProcessor;

public interface ImportItemOperation extends OperationProcessor<ImportItemResponse, ImportItemRequest> {
    ImportItemResponse process(ImportItemRequest importItemRequest);
}
