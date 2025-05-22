package pe.edu.upc.back_randomforest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.back_randomforest.entities.Archivo;
import pe.edu.upc.back_randomforest.repositories.IArchivoRepository;
import pe.edu.upc.back_randomforest.servicesinterfacces.IArchivoService;

import java.util.List;
@Service
public class ArchivoServiceImplement implements IArchivoService {
    @Autowired
    private IArchivoRepository aRA;
    @Override
    public void insert(Archivo archivo) {
        aRA.save(archivo);
    }

    @Override
    public void delete(int id) {
    aRA.deleteById(id);
    }

    @Override
    public Archivo listId(int id) {
        return aRA.findById(id).orElse(new Archivo());
    }

    @Override
    public List<Archivo> list() {
        return aRA.findAll();
    }

    @Override
    public boolean existsById(Integer idArchivo) {
        return aRA.existsById(idArchivo);
    }


}
