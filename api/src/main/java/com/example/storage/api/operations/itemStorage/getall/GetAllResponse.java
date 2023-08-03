package com.example.storage.api.operations.itemStorage.getall;

import com.example.storage.api.operations.base.OperationResult;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllResponse implements OperationResult {
   private Set<GetAllSingleItemResponse> itemResponseSet;
}
