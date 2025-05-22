package pe.edu.upc.back_randomforest.dtos;

import pe.edu.upc.back_randomforest.entities.Feature;

public class ResultadoDTO {
    private Long id;
    private int benigno;
    private String mensaje;
    private FeatureDTO feature; // Cambia a un objeto anidado para reflejar el JSON

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBenigno() {
        return benigno;
    }

    public void setBenigno(int benigno) {
        this.benigno = benigno;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public FeatureDTO getFeature() {
        return feature;
    }

    public void setFeature(FeatureDTO feature) {
        this.feature = feature;
    }
}