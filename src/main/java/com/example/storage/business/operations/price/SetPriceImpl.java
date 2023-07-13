package com.example.storage.business.operations.price;

import com.example.storage.api.operations.itemStorage.exportItem.ExportItemResponse;
import com.example.storage.api.operations.itemStorage.setPrice.SetPriceOperation;
import com.example.storage.api.operations.itemStorage.setPrice.SetPriceRequest;
import com.example.storage.api.operations.itemStorage.setPrice.SetPriceResponse;
import com.example.storage.data.models.ItemStorage;
import com.example.storage.data.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetPriceImpl implements SetPriceOperation {
    private final ItemStorageRepository itemStorageRepository;
    @Override
    public SetPriceResponse setPrice(SetPriceRequest setPriceRequest) {
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
