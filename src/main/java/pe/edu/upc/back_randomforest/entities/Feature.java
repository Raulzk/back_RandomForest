package pe.edu.upc.back_randomforest.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeature;

    private Integer bitcoinAddresses;
    private Integer debugRVA;
    private Integer debugSize;
    private Integer dllCharacteristics;
    private Integer exportRVA;
    private Integer exportSize;
    private Integer iatRVA; // Renombrado de "IatVRA" para mantener consistencia
    private Integer machine;
    private Integer majorImageVersion;
    private Integer majorLinkerVersion;
    private Integer majorOSVersion;
    private Integer minorLinkerVersion;
    private Integer numberOfSections;
    private Integer resourceSize;
    private Integer sizeOfStackReserve;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idArchivo", nullable = false)
    private Archivo archivo;

    public Feature() {
    }

    public Feature(Long idFeature, Integer bitcoinAddresses, Integer debugRVA, Integer debugSize, Integer dllCharacteristics,
                   Integer exportRVA, Integer exportSize, Integer iatRVA, Integer machine, Integer majorImageVersion,
                   Integer majorLinkerVersion, Integer majorOSVersion, Integer minorLinkerVersion, Integer numberOfSections,
                   Integer resourceSize, Integer sizeOfStackReserve, Archivo archivo) {
        this.idFeature = idFeature;
        this.bitcoinAddresses = bitcoinAddresses;
        this.debugRVA = debugRVA;
        this.debugSize = debugSize;
        this.dllCharacteristics = dllCharacteristics;
        this.exportRVA = exportRVA;
        this.exportSize = exportSize;
        this.iatRVA = iatRVA;
        this.machine = machine;
        this.majorImageVersion = majorImageVersion;
        this.majorLinkerVersion = majorLinkerVersion;
        this.majorOSVersion = majorOSVersion;
        this.minorLinkerVersion = minorLinkerVersion;
        this.numberOfSections = numberOfSections;
        this.resourceSize = resourceSize;
        this.sizeOfStackReserve = sizeOfStackReserve;
        this.archivo = archivo;
    }

    // Getters y Setters
    public Long getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Long idFeature) {
        this.idFeature = idFeature;
    }

    public Integer getBitcoinAddresses() {
        return bitcoinAddresses;
    }

    public void setBitcoinAddresses(Integer bitcoinAddresses) {
        this.bitcoinAddresses = bitcoinAddresses;
    }

    public Integer getDebugRVA() {
        return debugRVA;
    }

    public void setDebugRVA(Integer debugRVA) {
        this.debugRVA = debugRVA;
    }

    public Integer getDebugSize() {
        return debugSize;
    }

    public void setDebugSize(Integer debugSize) {
        this.debugSize = debugSize;
    }

    public Integer getDllCharacteristics() {
        return dllCharacteristics;
    }

    public void setDllCharacteristics(Integer dllCharacteristics) {
        this.dllCharacteristics = dllCharacteristics;
    }

    public Integer getExportRVA() {
        return exportRVA;
    }

    public void setExportRVA(Integer exportRVA) {
        this.exportRVA = exportRVA;
    }

    public Integer getExportSize() {
        return exportSize;
    }

    public void setExportSize(Integer exportSize) {
        this.exportSize = exportSize;
    }

    public Integer getIatRVA() {
        return iatRVA;
    }

    public void setIatRVA(Integer iatRVA) {
        this.iatRVA = iatRVA;
    }

    public Integer getMachine() {
        return machine;
    }

    public void setMachine(Integer machine) {
        this.machine = machine;
    }

    public Integer getMajorImageVersion() {
        return majorImageVersion;
    }

    public void setMajorImageVersion(Integer majorImageVersion) {
        this.majorImageVersion = majorImageVersion;
    }

    public Integer getMajorLinkerVersion() {
        return majorLinkerVersion;
    }

    public void setMajorLinkerVersion(Integer majorLinkerVersion) {
        this.majorLinkerVersion = majorLinkerVersion;
    }

    public Integer getMajorOSVersion() {
        return majorOSVersion;
    }

    public void setMajorOSVersion(Integer majorOSVersion) {
        this.majorOSVersion = majorOSVersion;
    }

    public Integer getMinorLinkerVersion() {
        return minorLinkerVersion;
    }

    public void setMinorLinkerVersion(Integer minorLinkerVersion) {
        this.minorLinkerVersion = minorLinkerVersion;
    }

    public Integer getNumberOfSections() {
        return numberOfSections;
    }

    public void setNumberOfSections(Integer numberOfSections) {
        this.numberOfSections = numberOfSections;
    }

    public Integer getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(Integer resourceSize) {
        this.resourceSize = resourceSize;
    }

    public Integer getSizeOfStackReserve() {
        return sizeOfStackReserve;
    }

    public void setSizeOfStackReserve(Integer sizeOfStackReserve) {
        this.sizeOfStackReserve = sizeOfStackReserve;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
}