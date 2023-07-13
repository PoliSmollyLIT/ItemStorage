package com.example.storage.api.operations.itemStorage.exportItem;

import com.example.storage.exceptions.NotEnoughQuantityOfSelectedItemException;

public interface ExportItemOperation {
    ExportItemResponse sellItem(ExportItemRequest exportItemRequest) throws NotEnoughQuantityOfSelectedItemException;
}
