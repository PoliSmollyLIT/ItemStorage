package com.example.storage.api.operations.itemStorage.importItem;

import com.example.storage.exceptions.NotEnoughQuantityOfSelectedItemException;

public interface ImportItemOperation {
    ImportItemResponse importItem(ImportItemRequest importItemRequest) throws NotEnoughQuantityOfSelectedItemException;
}
