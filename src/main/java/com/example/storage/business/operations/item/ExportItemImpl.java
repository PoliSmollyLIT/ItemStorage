package com.example.storage.business.operations.item;

import com.example.storage.api.operations.quantity.exportItem.ExportItemOperation;
import com.example.storage.api.operations.quantity.exportItem.ExportItemRequest;
import com.example.storage.api.operations.quantity.exportItem.ExportItemResponse;
import com.example.storage.data.models.ItemStorage;
import com.example.storage.data.repositories.ItemStorageRepository;
import com.example.storage.exceptions.NotEnoughQuantityOfSelectedItemException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExportItemImpl implements ExportItemOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public ExportItemResponse sellItem(ExportItemRequest exportItemRequest) throws NotEnoughQuantityOfSelectedItemException {
        ItemStorage storage = itemStorageRepository.findItemStorageById(exportItemRequest.getId());
        if(exportItemRequest.getQuantity() > storage.getQuantity()){
            throw new NotEnoughQuantityOfSelectedItemException();
        }
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
