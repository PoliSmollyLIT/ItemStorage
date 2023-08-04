package com.example.storage.core.operations.order;

import com.example.storage.api.operations.itemStorage.get.GetItemRequest;
import com.example.storage.api.operations.itemStorage.get.GetItemResponse;
import com.example.storage.api.operations.order.add.OrderAddOpeartion;
import com.example.storage.api.operations.order.add.OrderAddRequest;
import com.example.storage.api.operations.order.add.OrderAddResponse;
import com.example.storage.core.operations.item.GetItemImpl;
import com.example.storage.persistance.repositories.HistoryItemRepository;
import com.example.storage.persistance.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAddImpl implements OrderAddOpeartion {
    private final OrderRepository orderRepository;
    private final HistoryItemRepository historyItemRepository;
    private final GetItemImpl getItem;
    @Override
    public OrderAddResponse process(OrderAddRequest request) {

        request.getItems().stream()
                .forEach(item->
                {
                    GetItemResponse itemFromStrorage =  getItem.process(GetItemRequest.builder().id(item.getId()).build());
                    if (itemFromStrorage.getQuantity() >= item.getQuantity()) {

                    }
                });

        request.getItems().stream()
                .forEach(item ->{
                    request.setPrice(request.getPrice() + item.getPrice());
                });

        return null;
    }
}
