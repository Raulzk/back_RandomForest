package pe.edu.upc.back_randomforest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.back_randomforest.dtos.FeatureDTO;
import pe.edu.upc.back_randomforest.entities.Archivo;
import pe.edu.upc.back_randomforest.entities.Feature;
import pe.edu.upc.back_randomforest.repositories.IArchivoRepository;
import pe.edu.upc.back_randomforest.servicesinterfacces.IArchivoService;
import pe.edu.upc.back_randomforest.servicesinterfacces.IFeatureService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/features")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USUARIO')")
public class FeatureController {

    @Autowired
    private IFeatureService featureService;

    @Autowired
    private IArchivoRepository aSAS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USUARIO')")
    public void insertar(@RequestBody FeatureDTO dto){
        ModelMapper m=new ModelMapper();
        Feature v=m.map(dto,Feature.class);
        featureService.insert(v);
    }
/*
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody FeatureDTO featureDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Feature feature = modelMapper.map(featureDTO, Feature.class);

        // Asegúrate de que `feature.archivo` no sea null y que el `archivo` asignado sea una entidad persistente
        Archivo archivo = aSAS.findById(featureDTO.getArchivo().getIdArchivo())
                .orElseThrow(() -> new IllegalArgumentException("Archivo no encontrado"));
        feature.setArchivo(archivo);


        featureService.insert(feature);
    }*/
    @GetMapping
   @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<FeatureDTO> listar() {
        ModelMapper modelMapper = new ModelMapper();
        return featureService.list().stream()
                .map(feature -> modelMapper.map(feature, FeatureDTO.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public FeatureDTO listById(@PathVariable Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Feature feature = featureService.listId(id);
        return modelMapper.map(feature, FeatureDTO.class);
    }


/*
    @PostMapping("/insertar")

    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> insertar(@RequestBody FeatureDTO featureDTO) {
        ModelMapper modelMapper = new ModelMapper();

        // Mapea el DTO a la entidad Feature sin el archivo
        Feature feature = modelMapper.map(featureDTO, Feature.class);

        // Obtener y verificar el archivo
        Long idArchivoLong = featureDTO.getArchivo().getIdArchivo();
        if (idArchivoLong == null || !aSAS.existsById(idArchivoLong.intValue())) {
            return ResponseEntity.badRequest().body("El archivo especificado no existe.");
        }

        // Asigna la entidad Archivo completa desde la base de datos
        Archivo archivo = aSAS.findById(idArchivoLong.intValue()).orElse(null);
        feature.setArchivo(archivo);

        featureService.insert(feature); // Guarda la entidad Feature
        return ResponseEntity.ok("Características insertadas correctamente.");
    }*/
}
