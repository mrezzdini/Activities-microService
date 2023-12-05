package com.techno.activities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT s FROM Activity s WHERE s.name = ?1")
    Optional<Activity> findActivityByName(String name);

    List<Activity> findAllByWeeklyProgramId(Long weeklyProgramId);
}
