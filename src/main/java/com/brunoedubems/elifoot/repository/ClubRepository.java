package com.brunoedubems.elifoot.repository;

import com.brunoedubems.elifoot.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

}
