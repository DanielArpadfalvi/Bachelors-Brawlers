package hu.szte.brawlers.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
abstract public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer maxHp;
    private Integer intelligence;
    private Integer luck;
    private Integer endurance;
    private Integer dexterity;
}
