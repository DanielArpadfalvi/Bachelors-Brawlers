package hu.szte.brawlers.repository;

import hu.szte.brawlers.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> { }
