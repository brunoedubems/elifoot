package com.brunoedubems.elifoot.repository;

import com.brunoedubems.elifoot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
