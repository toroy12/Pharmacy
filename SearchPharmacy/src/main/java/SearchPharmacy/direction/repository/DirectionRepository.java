package SearchPharmacy.direction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SearchPharmacy.direction.entity.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
}