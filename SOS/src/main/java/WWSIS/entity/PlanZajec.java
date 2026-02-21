package WWSIS.entity;

import javax.persistence.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "plan_zajec") // Określenie nazwy tabeli w bazie danych, której ta encja dotyczy
public class PlanZajec {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "plan_zajec"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Klucz główny generowany przez bazę danych (autoinkrementacja)
    private Integer planId;

    // ===================== GETTERY =====================

    // Getter dla pola planId
    public Integer getPlanId() {
        return planId;
    }

    // Getter dla pola dzienTygodnia (dzień tygodnia, np. "Poniedziałek", "Wtorek")
    public String getDzienTygodnia() {
        return dzienTygodnia;
    }

    // Getter dla pola godzinaOd (godzina rozpoczęcia zajęć)
    public LocalTime getGodzinaOd() {
        return godzinaOd;
    }

    // Getter dla pola godzinaDo (godzina zakończenia zajęć)
    public LocalTime getGodzinaDo() {
        return godzinaDo;
    }

    // Getter dla pola sala (numer sali, w której odbywają się zajęcia)
    public String getSala() {
        return sala;
    }

    // Getter dla pola grupa (relacja z encją Grupa, wskazuje na grupę zajęciową)
    public Grupa getGrupa() {
        return grupa;
    }

    // ===================== SETTERY =====================

    // Setter dla pola planId
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    // Setter dla pola dzienTygodnia
    public void setDzienTygodnia(String dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    // Setter dla pola godzinaOd
    public void setGodzinaOd(LocalTime godzinaOd) {
        this.godzinaOd = godzinaOd;
    }

    // Setter dla pola godzinaDo
    public void setGodzinaDo(LocalTime godzinaDo) {
        this.godzinaDo = godzinaDo;
    }

    // Setter dla pola sala
    public void setSala(String sala) {
        this.sala = sala;
    }

    // Setter dla pola grupa (relacja z encją Grupa)
    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    // ===================== POLE =====================

    @Column(nullable = false) // Dzień tygodnia, np. "Poniedziałek", "Wtorek", nie może być pusty
    private String dzienTygodnia;

    private LocalTime godzinaOd; // Godzina rozpoczęcia zajęć

    private LocalTime godzinaDo; // Godzina zakończenia zajęć

    private String sala; // Numer sali, w której odbywają się zajęcia

    // Relacja wielu do jednego z encją Grupa (jedna grupa może mieć wiele planów zajęć)
    @ManyToOne
    @JoinColumn(name = "grupa_id", nullable = false) // Powiązanie z tabelą "grupa", kolumna "grupa_id"
    private Grupa grupa; // Grupa, która ma przypisany ten plan zajęć

}