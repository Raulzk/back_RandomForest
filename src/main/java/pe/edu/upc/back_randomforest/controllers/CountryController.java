package pe.edu.upc.back_randomforest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.back_randomforest.dtos.CountryDTO;
import pe.edu.upc.back_randomforest.entities.Country;
import pe.edu.upc.back_randomforest.servicesinterfacces.ICountryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("countries")
//@PreAuthorize("hasAnyAuthority('','','')")
public class CountryController {
    @Autowired
    private ICountryService iC;

    @PostMapping
    public void insertar(@RequestBody CountryDTO countryDTO){
        ModelMapper m=new ModelMapper();
        Country c=m.map(countryDTO, Country.class);
        iC.insert(c);
    }

    @GetMapping
    public List<CountryDTO> listar(){
        return iC.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, CountryDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ iC.delete(id);}

    @PutMapping
    public void update(@RequestBody CountryDTO dto) {
        ModelMapper m = new ModelMapper();
        Country u = m.map(dto, Country.class);
        iC.insert(u);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public CountryDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Country e = iC.listId(id);
        return m.map(e, CountryDTO.class);
    }
}
