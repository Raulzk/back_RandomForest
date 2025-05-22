package pe.edu.upc.back_randomforest.servicesinterfacces;

import pe.edu.upc.back_randomforest.entities.Feature;

import java.util.List;

public interface IFeatureService {
    //void insert(Feature feature);
    List<Feature> list();
    Feature listId(Long id);
    Feature insert(Feature feature);

}
