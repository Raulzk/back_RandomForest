package pe.edu.upc.back_randomforest.servicesinterfacces;

import pe.edu.upc.back_randomforest.entities.Country;


import java.util.List;

public interface ICountryService {
    public void insert(Country cntry);
    public void delete(int id);
    public Country listId(int id);
    public List<Country> list();
}
