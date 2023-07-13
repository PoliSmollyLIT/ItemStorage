package com.example.storage.data.repositories;

import com.example.storage.data.models.ItemStorage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemStorageRepository extends JpaRepository<ItemStorage, UUID> {
    ItemStorage findItemStorageById(UUID id);
}
