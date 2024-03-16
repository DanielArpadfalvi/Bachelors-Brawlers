package hu.szte.brawlers.converter;

import hu.szte.brawlers.model.Hero;
import hu.szte.brawlers.model.dto.HeroDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroConverter {
    private final ItemConverter itemConverter;
    public Hero DtoToHero(HeroDto heroDto) {
        Hero hero = new Hero();
        hero.setName(heroDto.getName());
        hero.setMaxHp(heroDto.getMaxHp());
        hero.setIntelligence(heroDto.getIntelligence());
        hero.setLuck(heroDto.getLuck());
        hero.setEndurance(heroDto.getEndurance());
        hero.setDexterity(heroDto.getDexterity());
        hero.setDiligence(heroDto.getDiligence());
        hero.setBackpackItems(heroDto.getBackpackItems().stream().map(itemConverter::dtoToItem).toList());
        hero.setEquipmentItems(heroDto.getEquipmentItems().stream().map(itemConverter::dtoToItem).toList());
        return hero;
    }

    public Hero updateHero(HeroDto heroDto, Hero hero) {
        hero.setName(heroDto.getName());
        hero.setMaxHp(heroDto.getMaxHp());
        hero.setIntelligence(heroDto.getIntelligence());
        hero.setLuck(heroDto.getLuck());
        hero.setEndurance(heroDto.getEndurance());
        hero.setDexterity(heroDto.getDexterity());
        hero.setDiligence(heroDto.getDiligence());
        hero.setBackpackItems(heroDto.getBackpackItems().stream().map(itemConverter::dtoToItem).toList());
        hero.setEquipmentItems(heroDto.getEquipmentItems().stream().map(itemConverter::dtoToItem).toList());
        return hero;
    }

    public HeroDto HeroToDto(Hero hero) {
        HeroDto heroDto = new HeroDto();
        heroDto.setName(hero.getName());
        heroDto.setMaxHp(hero.getMaxHp());
        heroDto.setIntelligence(hero.getIntelligence());
        heroDto.setLuck(hero.getLuck());
        heroDto.setEndurance(hero.getEndurance());
        heroDto.setDexterity(hero.getDexterity());
        heroDto.setDiligence(hero.getDiligence());
        heroDto.setBackpackItems(hero.getBackpackItems().stream().map(itemConverter::itemToDto).toList());
        heroDto.setEquipmentItems(hero.getEquipmentItems().stream().map(itemConverter::itemToDto).toList());
        return heroDto;
    }
}
