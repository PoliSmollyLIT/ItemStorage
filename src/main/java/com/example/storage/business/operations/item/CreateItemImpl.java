package com.example.storage.business.operations.item;

import com.example.storage.api.operations.itemStorage.createItem.CreateItemOperation;
import com.example.storage.api.operations.itemStorage.createItem.CreateItemRequest;
import com.example.storage.api.operations.itemStorage.createItem.CreateItemResponse;
import com.example.storage.data.models.ItemStorage;
import com.example.storage.data.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemImpl implements CreateItemOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public CreateItemResponse createItem(CreateItemRequest createItemRequest) {
        ItemStorage storage = ItemStorage.builder()
                .item(createItemRequest.getItem())
                .quantity(createItemRequest.getQuantity())
                .price(createItemRequest.getPrice())
                .build();
        itemStorageRepository.save(storage);
        CreateItemResponse response = CreateItemResponse.builder()
                .id(storage.getId())
                .item(storage.getItem())
                .quantity(storage.getQuantity())
                .price(storage.getPrice())
                .build();
        return response;
    }
}
