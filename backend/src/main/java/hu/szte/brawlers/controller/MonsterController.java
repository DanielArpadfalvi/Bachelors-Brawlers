package hu.szte.brawlers.controller;

import hu.szte.brawlers.model.dto.MonsterDto;
import hu.szte.brawlers.service.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monsters")
@RequiredArgsConstructor
public class MonsterController {

    private final MonsterService monsterService;

    @GetMapping
    public ResponseEntity<List<MonsterDto>> findAll() {
        return new ResponseEntity<>(monsterService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonsterDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(monsterService.getMonsterById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MonsterDto> addHero(@RequestBody MonsterDto monsterDto) {
        return new ResponseEntity<>(monsterService.addMonster(monsterDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonsterDto> updateHero(@RequestBody MonsterDto monsterDto, @PathVariable Long id) {
        return new ResponseEntity<>(monsterService.updateMonster(monsterDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        monsterService.deleteMonster(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
