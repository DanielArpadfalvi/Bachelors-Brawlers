package hu.szte.brawlers.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated
    private ItemCategory itemCategory;
    private String name;
    @Enumerated
    private Rarity rarity;
    @Nullable
    private Integer damageRange;
    @Nullable
    private Integer armor;
    @Nullable
    @ManyToMany
    private List<AttributeModifier> attributeModifiers;
}
