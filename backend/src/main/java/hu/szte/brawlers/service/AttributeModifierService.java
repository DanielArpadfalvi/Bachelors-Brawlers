package hu.szte.brawlers.service;

import hu.szte.brawlers.converter.AttributeModifierConverter;
import hu.szte.brawlers.model.AttributeModifier;
import hu.szte.brawlers.model.dto.AttributeModifierDto;
import hu.szte.brawlers.repository.AttributeModifierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttributeModifierService {
    private final AttributeModifierRepository attributeModifierRepository;
    private final AttributeModifierConverter attributeModifierConverter;

    public List<AttributeModifierDto> findAll() {
        return attributeModifierRepository.findAll().stream().map(attributeModifierConverter::attributeModifierToDto).collect(Collectors.toList());
    }

    public AttributeModifierDto getAttributeModifierById(Long id) {
        return attributeModifierConverter.attributeModifierToDto(attributeModifierRepository.findById(id).orElseThrow());
    }

    public void deleteAttributeModifier(Long id) {
        attributeModifierRepository.deleteById(id);
    }

    public AttributeModifierDto addAttributeModifier(AttributeModifierDto attributeModifierDto) {
        return attributeModifierConverter.attributeModifierToDto(attributeModifierRepository.save(attributeModifierConverter.dtoToAttributeModifier(attributeModifierDto)));
    }

    public AttributeModifierDto updateAttributeModifier(AttributeModifierDto attributeModifierDto, Long id) {
        AttributeModifier attributeModifier = attributeModifierRepository.findById(id).orElseThrow();
        return attributeModifierConverter.attributeModifierToDto(attributeModifierRepository.save(attributeModifierConverter.updateAttributeModifier(attributeModifier, attributeModifierDto)));
    }
}
