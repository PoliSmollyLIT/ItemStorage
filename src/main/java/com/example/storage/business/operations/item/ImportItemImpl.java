package com.example.storage.business.operations.item;

import com.example.storage.api.operations.quantity.importItem.ImportItemOperation;
import com.example.storage.api.operations.quantity.importItem.ImportItemRequest;
import com.example.storage.api.operations.quantity.importItem.ImportItemResponse;
import com.example.storage.data.models.ItemStorage;
import com.example.storage.data.repositories.ItemStorageRepository;
import com.example.storage.exceptions.NotEnoughQuantityOfSelectedItemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImportItemImpl implements ImportItemOperation {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public ImportItemResponse importItem(ImportItemRequest importItemRequest) throws NotEnoughQuantityOfSelectedItemException {
        ItemStorage storage = itemStorageRepository.findItemStorageById(importItemRequest.getId());
        if(importItemRequest.getQuantity() < 0){
            throw new NotEnoughQuantityOfSelectedItemException();
        }
        storage.setQuantity(storage.getQuantity() + importItemRequest.getQuantity());
        itemStorageRepository.save(storage);
        ImportItemResponse response = ImportItemResponse.builder()
                .id(storage.getId())
                .item(storage.getItem())
                .quantity(storage.getQuantity())
                .price(storage.getPrice())
                .build();
        return response;
    }
}
