package pe.edu.upc.back_randomforest.servicesinterfacces;

import pe.edu.upc.back_randomforest.entities.Archivo;

import java.util.List;

public interface IArchivoService {
    public void insert(Archivo archivo);
    public void delete(int id);
    public Archivo listId(int id);
    public List<Archivo> list();
    //
    boolean existsById(Integer idArchivo);

}
