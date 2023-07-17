package com.example.storage.core.operations.item;

import com.example.storage.api.operations.quantity.export.ExportItemOperation;
import com.example.storage.api.operations.quantity.export.ExportItemRequest;
import com.example.storage.api.operations.quantity.export.ExportItemResponse;
import com.example.storage.persistance.models.ItemStorage;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExportItemImpl implements ExportItemOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public ExportItemResponse process(ExportItemRequest exportItemRequest) {
        ItemStorage storage = itemStorageRepository.findItemStorageById(exportItemRequest.getId());

        storage.setQuantity(storage.getQuantity() - exportItemRequest.getQuantity());
        itemStorageRepository.save(storage);
        ExportItemResponse response = ExportItemResponse.builder()
                .id(storage.getId())
                .item(storage.getItem())
                .quantity(storage.getQuantity())
                .price(storage.getPrice())
                .build();
        return response;
    }
}
