package hu.szte.brawlers.controller;

import hu.szte.brawlers.model.dto.HeroDto;
import hu.szte.brawlers.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping
    public ResponseEntity<List<HeroDto>> findAll() {
        return new ResponseEntity<>(heroService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(heroService.getHeroById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HeroDto> addHero(@RequestBody HeroDto heroDto) {
        return new ResponseEntity<>(heroService.addHero(heroDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroDto> updateHero(@RequestBody HeroDto heroDto, @PathVariable Long id) {
        return new ResponseEntity<>(heroService.updateHero(heroDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHero(@PathVariable Long id) {
        heroService.deleteHero(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
