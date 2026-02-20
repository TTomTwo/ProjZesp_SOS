package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student") // Określenie nazwy tabeli w bazie danych, której ta encja dotyczy
public class Student {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "student"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Klucz główny generowany przez bazę danych (autoinkrementacja)
    private Integer id;

    // Pole przechowujące e-mail studenta
    @Column(nullable = false, unique = true) // E-mail musi być unikalny i nie może być pusty
    private String email;

    // Pole przechowujące hasło studenta (w rzeczywistości hasło powinno być haszowane)
    @Column(nullable = false) // Hasło nie może być puste
    private String haslo;

    // Pole przechowujące imię studenta
    @Column(nullable = false) // Imię nie może być puste
    private String imie;

    // Pole przechowujące nazwisko studenta
    @Column(nullable = false) // Nazwisko nie może być puste
    private String nazwisko;

    // Pole przechowujące numer indeksu studenta
    @Column(nullable = false, unique = true) // Numer indeksu musi być unikalny i nie może być pusty
    private String nrIndeksu;

    // Data rejestracji studenta, domyślnie ustawiona na dzisiejszą datę
    private LocalDate dataRejestracji = LocalDate.now();

    // ===================== GETTERY =====================

    // Getter dla pola id (identyfikator studenta)
    public Integer getId() {
        return id;
    }

    // Getter dla pola email (adres e-mail studenta)
    public String getEmail() {
        return email;
    }

    // Getter dla pola haslo (hasło studenta)
    public String getHaslo() {
        return haslo;
    }

    // Getter dla pola imie (imię studenta)
    public String getImie() {
        return imie;
    }

    // Getter dla pola nazwisko (nazwisko studenta)
    public String getNazwisko() {
        return nazwisko;
    }

    // Getter dla pola nrIndeksu (numer indeksu studenta)
    public String getNrIndeksu() {
        return nrIndeksu;
    }

    // Getter dla pola dataRejestracji (data rejestracji studenta)
    public LocalDate getDataRejestracji() {
        return dataRejestracji;
    }

    // ===================== SETTERY =====================

    // Setter dla pola id (identyfikator studenta)
    public void setId(Integer id) {
        this.id = id;
    }

    // Setter dla pola email (adres e-mail studenta)
    public void setEmail(String email) {
        this.email = email;
    }

    // Setter dla pola haslo (hasło studenta)
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    // Setter dla pola imie (imię studenta)
    public void setImie(String imie) {
        this.imie = imie;
    }

    // Setter dla pola nazwisko (nazwisko studenta)
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    // Setter dla pola nrIndeksu (numer indeksu studenta)
    public void setNrIndeksu(String nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    // Setter dla pola dataRejestracji (data rejestracji studenta)
    public void setDataRejestracji(LocalDate dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }
}