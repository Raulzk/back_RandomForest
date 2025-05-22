package pe.edu.upc.back_randomforest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Archivo")
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArchivo;
    @Column(name = "fileName", nullable = false, length = 200)
    private String fileName;
    @Column(name = "tipo", nullable = false, length = 200)
    private String tipo;

    @Column(name = "uploadDate")
    private LocalDate uploadDate;

    @Lob
    @Column(name = "fileData", nullable = false)
    private byte[] fileData;

    public Archivo() {
    }

    public Long getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public Archivo(Long idArchivo, String fileName, String tipo, LocalDate uploadDate, byte[] fileData) {
        this.idArchivo = idArchivo;
        this.fileName = fileName;
        this.tipo = tipo;
        this.uploadDate = uploadDate;
        this.fileData = fileData;
    }
}
