package com.example.storage.core.operations.item;

import com.example.storage.api.operations.itemStorage.create.CreateItemOperation;
import com.example.storage.api.operations.itemStorage.create.CreateItemRequest;
import com.example.storage.api.operations.itemStorage.create.CreateItemResponse;
import com.example.storage.persistance.models.ItemStorage;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import com.tinquinstore.zooostore.api.operations.item.get.GetItemResponse;
import com.tinquinstore.zooostore.restexport.ZooStoreRestClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemCore implements CreateItemOperation {
    private final ItemStorageRepository itemStorageRepository;
    private final ZooStoreRestClient zooStoreRestClient;
    @Override
    public CreateItemResponse process(CreateItemRequest createItemRequest) {

       try{
           GetItemResponse response = zooStoreRestClient.getItemById(String.valueOf(createItemRequest.getItem()));
       }catch (Exception e){
           throw new EntityNotFoundException("There is no such item");
       }
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
