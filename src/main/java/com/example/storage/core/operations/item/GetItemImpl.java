package com.example.storage.core.operations.item;

import com.example.storage.api.operations.itemStorage.get.GetItemOperation;
import com.example.storage.api.operations.itemStorage.get.GetItemRequest;
import com.example.storage.api.operations.itemStorage.get.GetItemResponse;
import com.example.storage.persistance.models.ItemStorage;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemImpl implements GetItemOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public GetItemResponse process(GetItemRequest getItemRequest) {
        ItemStorage item = itemStorageRepository.findItemStorageById(getItemRequest.getId());
        GetItemResponse response = GetItemResponse.builder()
                .id(item.getId())
                .item(item.getItem())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
        return response;
    }
}
