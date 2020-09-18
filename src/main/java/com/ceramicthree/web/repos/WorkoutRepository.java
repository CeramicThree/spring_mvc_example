package com.ceramicthree.web.repos;

import com.ceramicthree.web.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
