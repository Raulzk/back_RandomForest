package pe.edu.upc.back_randomforest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.back_randomforest.dtos.RoleDTO;

import pe.edu.upc.back_randomforest.entities.Role;
import pe.edu.upc.back_randomforest.servicesinterfacces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("roles")
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RoleController {
    @Autowired
    private IRoleService iR;

    @PostMapping
    public void insertar(@RequestBody RoleDTO roleDTO){
        ModelMapper m=new ModelMapper();
        Role r=m.map(roleDTO, Role.class);
        iR.insert(r);
    }

    @GetMapping
    public List<RoleDTO> listar(){
        return iR.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ iR.delete(id);}

    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(iR.listId(id), RoleDTO.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role u = m.map(dto, Role.class);
        iR.insert(u);
    }
}
