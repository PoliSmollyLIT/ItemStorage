package com.example.storage.persistance.repositories;

import com.example.storage.persistance.models.HistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, UUID> {


    Optional<HistoryItem> findHistoryItemByItem(UUID uuid);
}
