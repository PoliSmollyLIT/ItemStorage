package com.example.storage.business.operations.item;

import com.example.storage.api.operations.itemStorage.getItem.GetItemOperation;
import com.example.storage.api.operations.itemStorage.getItem.GetItemRequest;
import com.example.storage.api.operations.itemStorage.getItem.GetItemResponse;
import com.example.storage.data.models.ItemStorage;
import com.example.storage.data.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemImpl implements GetItemOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public GetItemResponse getItem(GetItemRequest getItemRequest) {
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
