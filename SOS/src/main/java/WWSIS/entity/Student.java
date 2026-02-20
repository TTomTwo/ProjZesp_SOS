package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(String nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public LocalDate getDataRejestracji() {
        return dataRejestracji;
    }

    public void setDataRejestracji(LocalDate dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String haslo; // hashed w realu

    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    @Column(nullable = false, unique = true)
    private String nrIndeksu;

    private LocalDate dataRejestracji = LocalDate.now();

    // gettery i settery – Alt+Insert → Getter and Setter → wybierz wszystkie pola
}