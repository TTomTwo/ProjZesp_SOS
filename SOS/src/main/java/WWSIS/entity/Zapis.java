package WWSIS.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "zapis")
public class Zapis {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "zapis"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zapisId;

    // Data zapisu studenta na grupę
    private LocalDate dataZapisu;

    // Status zapisu: "zapisany" lub "wypisany"
    private String status; // "zapisany", "wypisany"

    // Relacja wielu do jednego z encją Student
    @ManyToOne
    @JoinColumn(name = "student_id") // Powiązanie z tabelą "student", kolumna "student_id"
    private Student student;

    // Relacja wielu do jednego z encją Grupa
    @ManyToOne
    @JoinColumn(name = "grupa_id") // Powiązanie z tabelą "grupa", kolumna "grupa_id"
    private Grupa grupa;

    // ===================== GETTERY =====================

    // Getter dla pola zapisId
    public Integer getZapisId() {
        return zapisId;
    }

    // Getter dla pola dataZapisu
    public LocalDate getDataZapisu() {
        return dataZapisu;
    }

    // Getter dla pola status
    public String getStatus() {
        return status;
    }

    // Getter dla pola student (relacja z encją Student)
    public Student getStudent() {
        return student;
    }

    // Getter dla pola grupa (relacja z encją Grupa)
    public Grupa getGrupa() {
        return grupa;
    }

    // ===================== SETTERY =====================

    // Setter dla pola zapisId
    public void setZapisId(Integer zapisId) {
        this.zapisId = zapisId;
    }

    // Setter dla pola dataZapisu
    public void setDataZapisu(LocalDate dataZapisu) {
        this.dataZapisu = dataZapisu;
    }

    // Setter dla pola status
    public void setStatus(String status) {
        this.status = status;
    }

    // Setter dla pola student (ustawienie relacji z encją Student)
    public void setStudent(Student student) {
        this.student = student;
    }

    // Setter dla pola grupa (ustawienie relacji z encją Grupa)
    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }
}