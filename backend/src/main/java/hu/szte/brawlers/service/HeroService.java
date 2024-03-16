package hu.szte.brawlers.service;

import hu.szte.brawlers.converter.HeroConverter;
import hu.szte.brawlers.model.Hero;
import hu.szte.brawlers.model.dto.HeroDto;
import hu.szte.brawlers.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;
    private final HeroConverter heroConverter;

    public HeroDto getHeroById(Long id) {
        return heroConverter.HeroToDto(heroRepository.findById(id).orElseThrow());
    }

    public List<HeroDto> findAll(){
        return heroRepository.findAll().stream().map(heroConverter::HeroToDto).collect(Collectors.toList());
    }

    public HeroDto addHero(HeroDto heroDto) {
        return heroConverter.HeroToDto(heroRepository.save(heroConverter.DtoToHero(heroDto)));
    }

    public HeroDto updateHero(HeroDto heroDto, Long id) {
        Hero hero = heroRepository.findById(id).orElseThrow();
        return heroConverter.HeroToDto(heroRepository.save(heroConverter.updateHero(heroDto, hero)));
    }

    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }
}
