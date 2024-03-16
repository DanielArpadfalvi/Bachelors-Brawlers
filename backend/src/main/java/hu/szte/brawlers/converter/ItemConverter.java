package hu.szte.brawlers.converter;

import hu.szte.brawlers.model.AttributeModifier;
import hu.szte.brawlers.model.Item;
import hu.szte.brawlers.model.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ItemConverter {
    private final AttributeModifierConverter attributeModifierConverter;
    public Item dtoToItem(ItemDto itemDto){
        return Item.builder()
                .name(itemDto.getName())
                .itemCategory(itemDto.getItemCategory())
                .rarity(itemDto.getRarity())
                .armor(itemDto.getArmor())
                .damageRange(itemDto.getDamageRange())
                .attributeModifiers(itemDto.getAttributeModifierDtos().stream().map(attributeModifierConverter::dtoToAttributeModifier).toList())
                .build();
    }
    public ItemDto itemToDto(Item item){
        return ItemDto.builder()
                .name(item.getName())
                .itemCategory(item.getItemCategory())
                .rarity(item.getRarity())
                .armor(item.getArmor())
                .damageRange(item.getDamageRange())
                .attributeModifierDtos(Objects.requireNonNull(item.getAttributeModifiers()).stream().map(attributeModifierConverter::attributeModifierToDto).toList())
                .build();
    }

    public Item updateItem(Item item, ItemDto itemDto){
        item.setName(itemDto.getName());
        item.setItemCategory(itemDto.getItemCategory());
        item.setArmor(itemDto.getArmor());
        item.setRarity(itemDto.getRarity());
        item.setDamageRange(itemDto.getDamageRange());
        item.setAttributeModifiers(itemDto.getAttributeModifierDtos().stream().map(attributeModifierConverter::dtoToAttributeModifier).toList());
        return item;
    }
}
