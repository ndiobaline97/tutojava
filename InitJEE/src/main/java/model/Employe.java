package model;

import java.time.LocalDate;

public class Employe {

    private int id;
    private String matricule;
    private String nom;
    private String telephone;
    private LocalDate DateNaiss;
    private int salaire;
    private Service serviceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateNaiss() {
        return DateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        DateNaiss = dateNaiss;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }


}
