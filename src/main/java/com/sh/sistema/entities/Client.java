package com.sh.sistema.entities;

import com.sh.sistema.entities.enuns.Modality;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "client_tb")
public class Client {

    @Id
    private Integer matricula;
    private String name;
    private String adress;
    private Modality modality;

    public Client(){}

    public Client(Integer matricula, String name, String adress, Modality modality) {
        this.matricula = matricula;
        this.name = name;
        this.adress = adress;
        this.modality = modality;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(matricula, client.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public String toString() {
        return "Client{" +
                "matricula=" + matricula +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", modality=" + modality +
                '}';
    }
}
