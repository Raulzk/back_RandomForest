package pe.edu.upc.back_randomforest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.back_randomforest.dtos.ArchivoDTO;
import pe.edu.upc.back_randomforest.dtos.CityDTO;
import pe.edu.upc.back_randomforest.entities.Archivo;
import pe.edu.upc.back_randomforest.entities.City;
import pe.edu.upc.back_randomforest.servicesinterfacces.IArchivoService;
import pe.edu.upc.back_randomforest.servicesinterfacces.ICityService;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/archivos")
@PreAuthorize("hasAnyAuthority('EMPRENDIMIENTO','ADMIN','USUARIO')")
public class ArchivoController {
    @Autowired
    private IArchivoService iAS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void insertar(@RequestBody ArchivoDTO archivoDTO){
        ModelMapper m=new ModelMapper();
        Archivo ct=m.map(archivoDTO,Archivo.class);
        byte[] fileData = Base64.getDecoder().decode(archivoDTO.getFileData());
        ct.setFileData(fileData);  // Asignar el array de bytes a la instancia
        // Asignar el array de bytes
        iAS.insert(ct);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<ArchivoDTO> listar(){
        return iAS.list().stream().map(archivo -> {
            ModelMapper m = new ModelMapper();
            ArchivoDTO dto = m.map(archivo, ArchivoDTO.class);

            // Convertir byte[] a base64 para que se envíe como String
            dto.setFileData(Base64.getEncoder().encodeToString(archivo.getFileData()));

            return dto;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){ iAS.delete(id);}

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void update(@RequestBody ArchivoDTO dto) {
        ModelMapper m = new ModelMapper();
        Archivo u = m.map(dto, Archivo.class);
        iAS.insert(u);
    }


   /* public ArchivoDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Archivo e = iAS.listId(id);
        return m.map(e, ArchivoDTO.class);
    }*/
   @GetMapping("/{id}")
   @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ArchivoDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Archivo e = iAS.listId(id);
        ArchivoDTO dto = m.map(e, ArchivoDTO.class);

        // Convertir byte[] a base64 para que se envíe como String
        dto.setFileData(Base64.getEncoder().encodeToString(e.getFileData()));

        return dto;
    }

}
