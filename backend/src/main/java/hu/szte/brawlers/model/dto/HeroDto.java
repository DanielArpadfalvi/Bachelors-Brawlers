package hu.szte.brawlers.model.dto;

import hu.szte.brawlers.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroDto {
    private String name;
    private Integer maxHp;
    private Integer intelligence;
    private Integer luck;
    private Integer endurance;
    private Integer dexterity;
    private Integer diligence;
    private List<ItemDto> backpackItems;
    private List<ItemDto> equipmentItems;
    //...
}
