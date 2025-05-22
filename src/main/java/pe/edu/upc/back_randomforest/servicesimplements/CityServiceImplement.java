package pe.edu.upc.back_randomforest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.back_randomforest.entities.City;
import pe.edu.upc.back_randomforest.repositories.ICityRepository;
import pe.edu.upc.back_randomforest.servicesinterfacces.ICityService;

import java.util.List;

@Service
public class CityServiceImplement implements ICityService {
    @Autowired
    private ICityRepository cTRY;

    @Override
    public void insert(City cty) {
        cTRY.save(cty);
    }

    @Override
    public void delete(int id) {
        cTRY.deleteById(id);
    }

    @Override
    public City listId(int id) {
        return cTRY.findById(id).orElse(new City());
    }

    @Override
    public List<City> list() {
        return cTRY.findAll();
    }
}
