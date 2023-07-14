package com.example.storage.api.operations.quantity.exportItem;

import com.example.storage.exceptions.NotEnoughQuantityOfSelectedItemException;

public interface ExportItemOperation {
    ExportItemResponse sellItem(ExportItemRequest exportItemRequest) throws NotEnoughQuantityOfSelectedItemException;
}
