package com.example.storage.core.operations.price;

import com.example.storage.api.operations.price.set.SetPriceOperation;
import com.example.storage.api.operations.price.set.SetPriceRequest;
import com.example.storage.api.operations.price.set.SetPriceResponse;
import com.example.storage.persistance.models.ItemStorage;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetPriceImpl implements SetPriceOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public SetPriceResponse process(SetPriceRequest setPriceRequest) {
        ItemStorage storage = itemStorageRepository.findItemStorageById(setPriceRequest.getId());
        storage.setPrice(setPriceRequest.getPrice());
        itemStorageRepository.save(storage);
        SetPriceResponse response = SetPriceResponse.builder()
                .id(storage.getId())
                .item(storage.getItem())
                .quantity(storage.getQuantity())
                .price(storage.getPrice())
                .build();
        return response;
    }
}
