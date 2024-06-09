package cz.czechitas.java2webapps.ukol6.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

/**
 * Entita obsahující údaje zobrazené na vizitce.
 */
@Entity
public class Vizitka {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotBlank
    private String celeJmeno;
    @NotBlank
    private String firma;
    @NotBlank
    private String ulice;
    @NotBlank
    private String psc;
    private String email;
    private String telefon;
    private String web;

    public Vizitka() {
    }

    public Vizitka(String celeJmeno, String firma, String ulice, String psc, String email, String telefon, String web, int id) {
        this.web = web;
        this.telefon = telefon;
        this.email = email;
        this.psc = psc;
        this.ulice = ulice;
        this.firma = firma;
        this.celeJmeno = celeJmeno;
        this.id = id;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = Objects.requireNonNull(firma);
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = Objects.requireNonNull(ulice);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCelaAdresa() {

        return ulice+", "+psc;
    }
}
