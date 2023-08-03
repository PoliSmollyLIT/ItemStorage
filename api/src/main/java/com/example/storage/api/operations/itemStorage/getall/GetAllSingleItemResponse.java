package com.example.storage.api.operations.itemStorage.getall;

import com.example.storage.api.operations.base.OperationResult;
import lombok.*;

import java.util.UUID;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSingleItemResponse {
     private UUID storageID;
     private UUID itemID;
     private int quantity;
     private double price;
}
