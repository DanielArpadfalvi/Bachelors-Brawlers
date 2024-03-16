package hu.szte.brawlers.service;

import hu.szte.brawlers.converter.MonsterConverter;
import hu.szte.brawlers.model.Monster;
import hu.szte.brawlers.model.dto.MonsterDto;
import hu.szte.brawlers.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonsterService {

    private final MonsterRepository monsterRepository;
    private final MonsterConverter monsterConverter;

    public MonsterDto getMonsterById(Long id) {
        return monsterConverter.MonsterToDto(monsterRepository.findById(id).orElseThrow());
    }

    public List<MonsterDto> findAll(){
        return monsterRepository.findAll().stream().map(monsterConverter::MonsterToDto).collect(Collectors.toList());
    }

    public MonsterDto addMonster(MonsterDto monsterDto) {
        return monsterConverter.MonsterToDto(monsterRepository.save(monsterConverter.DtoToMonster(monsterDto)));
    }

    public MonsterDto updateMonster(MonsterDto monsterDto, Long id) {
        Monster monster = monsterRepository.findById(id).orElseThrow();
        return monsterConverter.MonsterToDto(monsterRepository.save(monsterConverter.updateMonster(monsterDto, monster)));
    }

    public void deleteMonster(Long id) {
        monsterRepository.deleteById(id);
    }
}
