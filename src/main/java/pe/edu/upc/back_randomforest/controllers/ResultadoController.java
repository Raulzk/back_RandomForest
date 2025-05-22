package pe.edu.upc.back_randomforest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.back_randomforest.dtos.ResultadoDTO;
import pe.edu.upc.back_randomforest.entities.Feature;
import pe.edu.upc.back_randomforest.entities.Resultado;
import pe.edu.upc.back_randomforest.repositories.IFeatureRepository; // Asegúrate de importar esto
import pe.edu.upc.back_randomforest.servicesinterfacces.IResultadoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resultados")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN','USUARIO')")
public class ResultadoController {
    @Autowired
    private IResultadoService rS;

    @Autowired
    private IFeatureRepository featureRepository; // Inyecta el FeatureRepository

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO', 'ADMIN')")
    public ResponseEntity<Void> insertar(@RequestBody ResultadoDTO resultadoDTO) {
        ModelMapper m = new ModelMapper();
        Resultado resultado = m.map(resultadoDTO, Resultado.class);

        // Si se proporciona idFeature, busca el Feature en la base de datos
        if (resultadoDTO.getId() != null) {
            Feature feature = featureRepository.findById(resultadoDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Feature no encontrado con id: " + resultadoDTO.getId()));
            resultado.setFeature(feature);
            System.out.println("Feature asignado con idFeature: " + feature.getIdFeature()); // Log para depurar
        } else {
            System.out.println("No se proporcionó idFeature en el DTO"); // Log para depurar
        }

        rS.insert(resultado);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Resto del código sin cambios
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO', 'ADMIN')")
    public ResponseEntity<List<ResultadoDTO>> list() {
        List<ResultadoDTO> resultadoDTOs = rS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            ResultadoDTO dto = m.map(y, ResultadoDTO.class);
            // No sobrescribas el id; ModelMapper ya mapea correctamente el id del Resultado
            // El feature se mapea automáticamente a FeatureDTO
            return dto;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(resultadoDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO', 'ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        System.out.println("Solicitud DELETE recibida para ID: " + id);
        rS.delete(id);
        System.out.println("Proceso de eliminación completado para ID: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USUARIO', 'EMPRENDIMIENTO', 'ADMIN')")
    public ResponseEntity<ResultadoDTO> listById(@PathVariable("id") Long id) {
        Resultado resultado = rS.listId(id);
        if (resultado == null || resultado.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ModelMapper m = new ModelMapper();
        ResultadoDTO dto = m.map(resultado, ResultadoDTO.class);
        // No sobrescribas el id; ModelMapper ya lo hace bien
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}