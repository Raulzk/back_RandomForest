package pe.edu.upc.back_randomforest.servicesinterfacces;

import pe.edu.upc.back_randomforest.entities.Role;

import java.util.List;

public interface IRoleService {

    public void insert(Role rle);
    public List<Role> list();
    public void delete(int id);
    public Role listId(Integer idRol);
}
