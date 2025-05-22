package pe.edu.upc.back_randomforest.servicesinterfacces;

import pe.edu.upc.back_randomforest.entities.Resultado;

import java.util.List;

public interface IResultadoService {
    public void insert(Resultado r);
    public List<Resultado> list();
    public void delete(Long id);
    public Resultado listId(Long id);
}
