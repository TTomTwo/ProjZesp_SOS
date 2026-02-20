package WWSIS.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "oplata") // Określenie nazwy tabeli w bazie danych, której ta encja dotyczy
public class Oplata {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "oplata"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Klucz główny generowany przez bazę danych (autoinkrementacja)
    private Integer oplataId;

    // ===================== GETTERY =====================

    // Getter dla pola oplataId
    public Integer getOplataId() {
        return oplataId;
    }

    // Getter dla pola kwota (kwota opłaty)
    public BigDecimal getKwota() {
        return kwota;
    }

    // Getter dla pola dataPlatnosci (data płatności)
    public LocalDate getDataPlatnosci() {
        return dataPlatnosci;
    }

    // Getter dla pola typ (typ opłaty, np. "czesne", "legitymacja")
    public String getTyp() {
        return typ;
    }

    // Getter dla pola status (status płatności, np. "oplacone", "nieoplacone")
    public String getStatus() {
        return status;
    }

    // Getter dla pola student (relacja z encją Student, wskazuje na studenta, który zapłacił)
    public Student getStudent() {
        return student;
    }

    // ===================== SETTERY =====================

    // Setter dla pola oplataId
    public void setOplataId(Integer oplataId) {
        this.oplataId = oplataId;
    }

    // Setter dla pola kwota (ustawia kwotę opłaty)
    public void setKwota(BigDecimal kwota) {
        this.kwota = kwota;
    }

    // Setter dla pola dataPlatnosci (ustawia datę płatności)
    public void setDataPlatnosci(LocalDate dataPlatnosci) {
        this.dataPlatnosci = dataPlatnosci;
    }

    // Setter dla pola typ (ustawia typ opłaty)
    public void setTyp(String typ) {
        this.typ = typ;
    }

    // Setter dla pola status (ustawia status płatności)
    public void setStatus(String status) {
        this.status = status;
    }

    // Setter dla pola student (ustawia relację z encją Student)
    public void setStudent(Student student) {
        this.student = student;
    }

    // ===================== POLE =====================

    @Column(nullable = false) // Kwota opłaty, nie może być pusta
    private BigDecimal kwota;

    private LocalDate dataPlatnosci; // Data płatności

    private String typ; // Typ opłaty, np. "czesne", "legitymacja", "dyplom"

    private String status; // Status płatności, np. "oplacone", "nieoplacone"

    // Relacja wielu do jednego z encją Student (jeden student może mieć wiele opłat)
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false) // Kolumna "student_id" wskazująca na studenta
    private Student student; // Student, który zapłacił za daną opłatę

}