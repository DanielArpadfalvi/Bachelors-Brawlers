package hu.szte.brawlers.converter;

import hu.szte.brawlers.model.Monster;
import hu.szte.brawlers.model.dto.MonsterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MonsterConverter {
    public Monster DtoToMonster(MonsterDto monsterDto) {
        Monster monster = new Monster();
        monster.setName(monsterDto.getName());
        monster.setMaxHp(monsterDto.getMaxHp());
        monster.setIntelligence(monsterDto.getIntelligence());
        monster.setLuck(monsterDto.getLuck());
        monster.setEndurance(monsterDto.getEndurance());
        monster.setDexterity(monsterDto.getDexterity());
        monster.setDamageRange(monsterDto.getDamageRange());
        return monster;
    }

    public Monster updateMonster(MonsterDto monsterDto, Monster monster) {
        monster.setName(monsterDto.getName());
        monster.setMaxHp(monsterDto.getMaxHp());
        monster.setIntelligence(monsterDto.getIntelligence());
        monster.setLuck(monsterDto.getLuck());
        monster.setEndurance(monsterDto.getEndurance());
        monster.setDexterity(monsterDto.getDexterity());
        monster.setDamageRange(monsterDto.getDamageRange());
        return monster;
    }

    public MonsterDto MonsterToDto(Monster monster) {
        MonsterDto monsterDto = new MonsterDto();
        monsterDto.setName(monster.getName());
        monsterDto.setMaxHp(monster.getMaxHp());
        monsterDto.setIntelligence(monster.getIntelligence());
        monsterDto.setLuck(monster.getLuck());
        monsterDto.setEndurance(monster.getEndurance());
        monsterDto.setDexterity(monster.getDexterity());
        monsterDto.setDamageRange(monster.getDamageRange());
        return monsterDto;
    }
}
