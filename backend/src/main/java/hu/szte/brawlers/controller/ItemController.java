package hu.szte.brawlers.controller;

import hu.szte.brawlers.model.dto.ItemDto;
import hu.szte.brawlers.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDto>> findAll() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto) {
        return new ResponseEntity<>(itemService.addItem(itemDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(@RequestBody ItemDto itemDto, @PathVariable Long id) {
        return new ResponseEntity<>(itemService.updateItem(itemDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
