package WWSIS.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "przedmiot") // Określenie nazwy tabeli w bazie danych, której ta encja dotyczy
public class Przedmiot {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "przedmiot"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Klucz główny generowany przez bazę danych (autoinkrementacja)
    private Integer przedmiotId;

    // ===================== GETTERY =====================

    // Getter dla pola przedmiotId (identyfikator przedmiotu)
    public Integer getPrzedmiotId() {
        return przedmiotId;
    }

    // Getter dla pola nazwa (nazwa przedmiotu)
    public String getNazwa() {
        return nazwa;
    }

    // Getter dla pola opis (opis przedmiotu)
    public String getOpis() {
        return opis;
    }

    // Getter dla pola ects (liczba punktów ECTS przypisanych do przedmiotu)
    public int getEcts() {
        return ects;
    }

    // Getter dla pola prowadzacy (prowadzący przedmiot)
    public String getProwadzacy() {
        return prowadzacy;
    }

    // Getter dla pola grupy (lista grup przypisanych do przedmiotu)
    public List<Grupa> getGrupy() {
        return grupy;
    }

    // ===================== SETTERY =====================

    // Setter dla pola przedmiotId
    public void setPrzedmiotId(Integer przedmiotId) {
        this.przedmiotId = przedmiotId;
    }

    // Setter dla pola nazwa
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    // Setter dla pola opis
    public void setOpis(String opis) {
        this.opis = opis;
    }

    // Setter dla pola ects
    public void setEcts(int ects) {
        this.ects = ects;
    }

    // Setter dla pola prowadzacy
    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    // Setter dla pola grupy (powiązanie z grupami przypisanymi do przedmiotu)
    public void setGrupy(List<Grupa> grupy) {
        this.grupy = grupy;
    }

    // ===================== POLE =====================

    @Column(nullable = false) // Nazwa przedmiotu, która nie może być pusta
    private String nazwa;

    private String opis; // Opcjonalny opis przedmiotu

    private int ects; // Liczba punktów ECTS przypisanych do przedmiotu

    private String prowadzacy; // Prowadzący przedmiot

    // Relacja jeden do wielu z encją Grupa
    @OneToMany(mappedBy = "przedmiot") // Grupa ma pole "przedmiot" które wskazuje na ten przedmiot
    private List<Grupa> grupy; // Lista grup przypisanych do tego przedmiotu

}