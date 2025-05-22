package pe.edu.upc.back_randomforest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resultados")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "idFeature", referencedColumnName = "idFeature", nullable = true)
    private Feature feature;

    @Column(name = "benigno", nullable = false)
    private int benigno; // 1 para benigno, 0 para malicioso

    @Column(name = "mensaje", nullable = false)
    private String mensaje;

    public Resultado() {
    }

    public Resultado(Long id, Feature feature, int benigno, String mensaje) {
        this.id = id;
        this.feature = feature;
        this.benigno = benigno;
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
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

}
