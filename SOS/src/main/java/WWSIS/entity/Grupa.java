package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "grupa") // Określenie nazwy tabeli w bazie danych, której ta encja dotyczy
public class Grupa {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "grupa"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Klucz główny generowany przez bazę danych (autoinkrementacja)
    private Integer grupaId;

    // ===================== GETTERY =====================

    // Getter dla pola grupaId
    public Integer getGrupaId() {
        return grupaId;
    }

    // Getter dla pola nazwa (nazwa grupy)
    public String getNazwa() {
        return nazwa;
    }

    // Getter dla pola limitMiejsc (limit miejsc w grupie)
    public int getLimitMiejsc() {
        return limitMiejsc;
    }

    // Getter dla pola sala (numer sali, w której odbywają się zajęcia)
    public String getSala() {
        return sala;
    }

    // Getter dla pola godzinaOd (godzina rozpoczęcia zajęć)
    public LocalTime getGodzinaOd() {
        return godzinaOd;
    }

    // Getter dla pola godzinaDo (godzina zakończenia zajęć)
    public LocalTime getGodzinaDo() {
        return godzinaDo;
    }

    // Getter dla pola przedmiot (relacja z encją Przedmiot, wskazuje na przedmiot, który jest realizowany w grupie)
    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    // Getter dla pola zapisy (lista zapisów studenckich do tej grupy)
    public List<Zapis> getZapisy() {
        return zapisy;
    }

    // ===================== SETTERY =====================

    // Setter dla pola grupaId
    public void setGrupaId(Integer grupaId) {
        this.grupaId = grupaId;
    }

    // Setter dla pola nazwa
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    // Setter dla pola limitMiejsc
    public void setLimitMiejsc(int limitMiejsc) {
        this.limitMiejsc = limitMiejsc;
    }

    // Setter dla pola sala
    public void setSala(String sala) {
        this.sala = sala;
    }

    // Setter dla pola godzinaOd
    public void setGodzinaOd(LocalTime godzinaOd) {
        this.godzinaOd = godzinaOd;
    }

    // Setter dla pola godzinaDo
    public void setGodzinaDo(LocalTime godzinaDo) {
        this.godzinaDo = godzinaDo;
    }

    // Setter dla pola przedmiot (ustawienie relacji z encją Przedmiot)
    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    // Setter dla pola zapisy (ustawienie listy zapisów do grupy)
    public void setZapisy(List<Zapis> zapisy) {
        this.zapisy = zapisy;
    }

    // ===================== POLE =====================

    @Column(nullable = false) // Nazwa grupy, nie może być pusta
    private String nazwa;

    private int limitMiejsc; // Limit miejsc w grupie

    private String sala; // Numer sali, w której odbywają się zajęcia

    private LocalTime godzinaOd; // Godzina rozpoczęcia zajęć

    private LocalTime godzinaDo; // Godzina zakończenia zajęć

    // Relacja wielu do jednego z encją Przedmiot (jedna grupa realizuje jeden przedmiot)
    @ManyToOne
    @JoinColumn(name = "przedmiot_id") // Powiązanie z tabelą "przedmiot", kolumna "przedmiot_id"
    private Przedmiot przedmiot; // Przedmiot realizowany przez grupę

    // Relacja jeden do wielu z encją Zapis (jedna grupa może mieć wiele zapisanych studentów)
    @OneToMany(mappedBy = "grupa") // Powiązanie z tabelą "zapis", gdzie kolumna "grupa" wskazuje na tę grupę
    private List<Zapis> zapisy; // Lista zapisów studentów do tej grupy
}