package com.example.storage.core.operations.item;

import com.example.storage.api.operations.itemStorage.get.GetItemOperation;
import com.example.storage.api.operations.itemStorage.get.GetItemRequest;
import com.example.storage.api.operations.itemStorage.get.GetItemResponse;
import com.example.storage.persistance.models.ItemStorage;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class GetItemCore implements GetItemOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public GetItemResponse process(GetItemRequest getItemRequest) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ItemStorage item = itemStorageRepository.findItemStorageByItem(getItemRequest.getId()).orElseThrow(()->new EntityNotFoundException("Item with this id does not exist"));
        GetItemResponse response = GetItemResponse.builder()
                .id(item.getId())
                .item(item.getItem())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();
        return response;
    }
}
