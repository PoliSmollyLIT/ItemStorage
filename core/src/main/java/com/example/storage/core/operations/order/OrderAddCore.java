package com.example.storage.core.operations.order;

import com.example.storage.api.operations.itemStorage.get.GetItemRequest;
import com.example.storage.api.operations.itemStorage.get.GetItemResponse;
import com.example.storage.api.operations.order.add.OrderAddOpeartion;
import com.example.storage.api.operations.order.add.OrderAddOrderItem;
import com.example.storage.api.operations.order.add.OrderAddRequest;
import com.example.storage.api.operations.order.add.OrderAddResponse;
import com.example.storage.api.operations.quantity.export.ExportItemRequest;
import com.example.storage.api.operations.quantity.export.ExportItemResponse;
import com.example.storage.core.operations.item.ExportItemCore;
import com.example.storage.core.operations.item.GetItemCore;
import com.example.storage.persistance.models.HistoryItem;
import com.example.storage.persistance.models.Order;
import com.example.storage.persistance.repositories.HistoryItemRepository;
import com.example.storage.persistance.repositories.ItemStorageRepository;
import com.example.storage.persistance.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderAddCore implements OrderAddOpeartion {
    private final OrderRepository orderRepository;
    private final HistoryItemRepository historyItemRepository;
    private final ItemStorageRepository itemStorageRepository;
    private final GetItemCore getItem;
    private final ExportItemCore exportItem;
    @Override
    public OrderAddResponse process(OrderAddRequest request) {
        request.getItems().stream()
                .forEach(item->
                {
                    GetItemResponse itemFromStrorage =  getItem.process(GetItemRequest.builder().id(item.getId()).build());
                    if (itemFromStrorage.getQuantity() < item.getQuantity()) {
                       throw new RuntimeException("Not enough quantity of " + item.getId());
                    }
                });

        request.getItems().stream()
                .forEach(item ->{
                    ExportItemResponse exportItemFromStorage = exportItem.process(ExportItemRequest.builder()
                            .id(item.getId())
                            .quantity(-item.getQuantity())
                            .build());
                });

        request.getItems().stream().forEach(item->{
            historyItemRepository.save(HistoryItem.builder()
                            .item(item.getId())
                            .price(item.getPrice())
                            .quantity(item.getQuantity())
                    .build());
        });

        Order order = Order.builder()
                .price(request.getPrice())
                .items(request.getItems().stream()
                        .map(item -> {
                                    HistoryItem hItem = historyItemRepository.findHistoryItemByItem(item.getId())
                                            .orElseThrow(() -> new EntityNotFoundException("History item with this ID does not exist"));
                               return hItem;
                                }
                        ).collect(Collectors.toList()))
                .user(request.getUser())
                .build();
        orderRepository.save(order);
        return OrderAddResponse.builder().result("Sucessfully added order").build();
    }
}
