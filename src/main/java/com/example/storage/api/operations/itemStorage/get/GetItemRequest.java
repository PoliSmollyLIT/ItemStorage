package com.example.storage.api.operations.itemStorage.get;

import com.example.storage.api.operations.base.OperationInput;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetItemRequest implements OperationInput {
       private UUID id;
}
