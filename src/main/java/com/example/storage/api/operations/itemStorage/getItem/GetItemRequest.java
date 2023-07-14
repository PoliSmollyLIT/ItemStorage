package com.example.storage.api.operations.itemStorage.getItem;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetItemRequest {
       private UUID id;
}
