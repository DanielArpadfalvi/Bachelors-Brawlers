package hu.szte.brawlers.model.dto;

import hu.szte.brawlers.model.AttributeModifier;
import hu.szte.brawlers.model.ItemCategory;
import hu.szte.brawlers.model.Rarity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemDto {
    private ItemCategory itemCategory;
    private String name;
    private Rarity rarity;
    private Integer damageRange;
    private Integer armor;
    private List<AttributeModifierDto> attributeModifierDtos;
}
