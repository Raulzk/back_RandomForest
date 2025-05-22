package pe.edu.upc.back_randomforest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.back_randomforest.entities.Feature;
import pe.edu.upc.back_randomforest.repositories.IFeatureRepository;
import pe.edu.upc.back_randomforest.servicesinterfacces.IFeatureService;

import java.util.List;
@Service
public class FeatureServiceImplement implements IFeatureService {
    @Autowired
    private IFeatureRepository FR;
  /*  @Override
    public void insert(Feature feature) {
        FR.save(feature);
    }
*/

    @Override
    public List<Feature> list() {
        return FR.findAll();
    }

    @Override
    public Feature listId(Long id) {
        return FR.findById(id).orElse(null);
    }

    @Override
    public Feature insert(Feature feature) {
        return  FR.save(feature);
    }




}
