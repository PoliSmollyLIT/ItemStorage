package com.example.storage.core.operations.item;

import com.example.storage.api.operations.quantity.importItem.ImportItemOperation;
import com.example.storage.api.operations.quantity.importItem.ImportItemRequest;
import com.example.storage.api.operations.quantity.importItem.ImportItemResponse;
import com.example.storage.persistance.models.ItemStorage;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImportItemImpl implements ImportItemOperation {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public ImportItemResponse process(ImportItemRequest importItemRequest) {
        ItemStorage storage = itemStorageRepository.findItemStorageById(importItemRequest.getId());

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
