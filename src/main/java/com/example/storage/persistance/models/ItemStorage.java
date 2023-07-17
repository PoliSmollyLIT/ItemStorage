package com.example.storage.persistance.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "storage")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID item;

    private int quantity;

    private double price;

}
