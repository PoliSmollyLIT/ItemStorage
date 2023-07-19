package com.example.storage.persistance.repositories;

import com.example.storage.persistance.models.ItemStorage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ItemStorageRepository extends JpaRepository<ItemStorage, UUID> {
    Optional<ItemStorage> findItemStorageById(UUID id);
    Set<ItemStorage> findItemStorageByItem(UUID itemId);
}
