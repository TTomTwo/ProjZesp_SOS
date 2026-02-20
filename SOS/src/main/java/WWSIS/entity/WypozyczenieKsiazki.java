package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wypozyczenie_ksiazki") // Określenie nazwy tabeli w bazie danych, której ta encja dotyczy
public class WypozyczenieKsiazki {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "wypozyczenie_ksiazki"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identyfikator generowany przez bazę danych (autoinkrementacja)
    private Integer wypozyczenieId;

    // Pole przechowujące tytuł książki
    @Column(nullable = false) // Tytuł nie może być pusty w bazie danych
    private String tytul;

    // Data wypożyczenia książki
    private LocalDate dataWypozyczenia;

    // Data zwrotu książki
    private LocalDate dataZwrotu;

    // Status wypożyczenia: "wypozyczona", "zwrocona", "przeterminowana"
    private String status; // Możliwe wartości: "wypozyczona", "zwrocona", "przeterminowana"

    // Relacja wielu do jednego z encją Student (jeden student może wypożyczyć wiele książek)
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false) // Powiązanie z tabelą "student" po kolumnie "student_id"
    private Student student;

    // ===================== GETTERY =====================

    // Getter dla pola wypozyczenieId
    public Integer getWypozyczenieId() {
        return wypozyczenieId;
    }

    // Getter dla pola tytul
    public String getTytul() {
        return tytul;
    }

    // Getter dla pola dataWypozyczenia
    public LocalDate getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    // Getter dla pola dataZwrotu
    public LocalDate getDataZwrotu() {
        return dataZwrotu;
    }

    // Getter dla pola status
    public String getStatus() {
        return status;
    }

    // Getter dla pola student
    public Student getStudent() {
        return student;
    }

    // ===================== SETTERY =====================

    // Setter dla pola wypozyczenieId
    public void setWypozyczenieId(Integer wypozyczenieId) {
        this.wypozyczenieId = wypozyczenieId;
    }

    // Setter dla pola tytul
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    // Setter dla pola dataWypozyczenia
    public void setDataWypozyczenia(LocalDate dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    // Setter dla pola dataZwrotu
    public void setDataZwrotu(LocalDate dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    // Setter dla pola status
    public void setStatus(String status) {
        this.status = status;
    }

    // Setter dla pola student (relacja z encją Student)
    public void setStudent(Student student) {
        this.student = student;
    }
}