package pe.edu.upc.back_randomforest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.back_randomforest.entities.Feature;

import java.util.List;
@Repository
public interface IFeatureRepository  extends JpaRepository<Feature,Long> {

}
