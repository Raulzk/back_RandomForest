package pe.edu.upc.back_randomforest.servicesinterfacces;

import pe.edu.upc.back_randomforest.entities.City;


import java.util.List;

public interface ICityService {
    public void insert(City cty);
    public void delete(int id);
    public City listId(int id);
    public List<City> list();
}
