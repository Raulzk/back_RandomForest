package pe.edu.upc.back_randomforest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.back_randomforest.entities.City;

@Repository
public interface ICityRepository extends JpaRepository<City, Integer> {
}
