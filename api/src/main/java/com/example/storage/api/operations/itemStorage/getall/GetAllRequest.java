package com.example.storage.api.operations.itemStorage.getall;

import com.example.storage.api.operations.base.OperationInput;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRequest implements OperationInput {
    private Set<UUID> items;
}
