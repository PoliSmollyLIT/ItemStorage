package com.example.storage.persistance.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID user;
    private Double price;

    @CreationTimestamp(source = SourceType.DB)
    @Column(nullable = false, updatable = false, insertable = false)
    private Timestamp timestamp;

    @OneToMany(mappedBy = "order")
    private List<HistoryItem> items;
}
