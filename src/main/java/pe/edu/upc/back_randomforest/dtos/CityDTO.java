package pe.edu.upc.back_randomforest.dtos;

import pe.edu.upc.back_randomforest.entities.Country;

public class CityDTO {
    private int idCity;
    private String nameCity;
    private Country counTry;

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public Country getCounTry() {
        return counTry;
    }

    public void setCounTry(Country counTry) {
        this.counTry = counTry;
    }
}
