package hu.szte.brawlers.service;

import hu.szte.brawlers.converter.ItemConverter;
import hu.szte.brawlers.model.AttributeModifier;
import hu.szte.brawlers.model.Item;
import hu.szte.brawlers.model.dto.ItemDto;
import hu.szte.brawlers.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemConverter itemConverter;
    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream().map(itemConverter::itemToDto).toList();
    }

    public ItemDto getItemById(Long id) {
        return itemConverter.itemToDto(itemRepository.findById(id).orElseThrow());
    }

    public ItemDto addItem(ItemDto itemDto) {
        return itemConverter.itemToDto(itemRepository.save(itemConverter.dtoToItem(itemDto)));
    }

    public ItemDto updateItem(ItemDto itemDto, Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        return itemConverter.itemToDto(itemRepository.save(itemConverter.updateItem(item, itemDto)));
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
