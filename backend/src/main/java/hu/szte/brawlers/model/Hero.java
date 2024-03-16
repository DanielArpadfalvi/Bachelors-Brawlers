package hu.szte.brawlers.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Hero extends BaseEntity {
    private Integer diligence;
    private Long xp;
    private Integer forint;
    private Integer crypto;

    @OneToMany
    private List<Item> equipmentItems;

    @OneToMany
    private List<Item> backpackItems;
}
