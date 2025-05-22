package pe.edu.upc.back_randomforest.servicesinterfacces;

import pe.edu.upc.back_randomforest.entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users usr);
    public void delete(int id);
    public Users listId(Integer idUsuario);
    public List<Users> list();

    public int findLastUserRegister();

    public int findByNameRole(String name_role);
    public int findByNameCountry( String name_country);
}
