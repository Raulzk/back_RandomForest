package pe.edu.upc.back_randomforest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.back_randomforest.entities.Resultado;
import pe.edu.upc.back_randomforest.repositories.IResultadoRepository;
import pe.edu.upc.back_randomforest.servicesinterfacces.IResultadoService;

import java.util.List;

@Service
public class ResultadoServiceImplement implements IResultadoService {
    @Autowired
    private IResultadoRepository RR;

    @Override
    public void insert(Resultado r) {
        RR.save(r);
    }

    @Override
    public List<Resultado> list() {
        return RR.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        System.out.println("Buscando resultado con ID: " + id);
        if (RR.existsById(id)) {
            RR.deleteById(id);
            System.out.println("Resultado con ID " + id + " eliminado de la base de datos");
        } else {
            System.out.println("No se encontró resultado con ID: " + id);
            // No lanzar excepción, simplemente no hacer nada
        }
    }

    @Override
    public Resultado listId(Long id) {
        return RR.findById(id).orElse(new Resultado());
    }
}