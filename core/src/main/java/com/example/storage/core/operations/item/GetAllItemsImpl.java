package com.example.storage.core.operations.item;

import com.example.storage.api.operations.itemStorage.getall.GetAllOperation;
import com.example.storage.api.operations.itemStorage.getall.GetAllRequest;
import com.example.storage.api.operations.itemStorage.getall.GetAllResponse;
import com.example.storage.api.operations.itemStorage.getall.GetAllSingleItemResponse;
import com.example.storage.persistance.models.ItemStorage;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GetAllItemsImpl implements GetAllOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public GetAllResponse process(GetAllRequest input) {
        /*Set<ItemStorage> itemStorage = itemStorageRepository.findItemStoragesByItem(input.getItems());
        Set<GetAllSingleItemResponse> itemResponses = new HashSet<>();
        for (ItemStorage item:itemStorage) {
            GetAllSingleItemResponse itemResponse = GetAllSingleItemResponse.builder()
                    .itemID(item.getItem())
                    .storageID(item.getId())
                    .price(item.getPrice())
                    .quantity(item.getQuantity())
                    .build();
            itemResponses.add(itemResponse);
        }
        GetAllResponse response = GetAllResponse.builder()
                .itemResponseSet(itemResponses)
                .build();*/
        return null;
    }
}
