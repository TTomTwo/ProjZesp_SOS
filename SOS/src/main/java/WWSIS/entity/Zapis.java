package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "zapis")
public class Zapis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zapisId;

    private LocalDate dataZapisu;

    private String status; // "zapisany", "wypisany"

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "grupa_id")
    private Grupa grupa;

    // ===================== GETTERY =====================

    public Integer getZapisId() {
        return zapisId;
    }

    public LocalDate getDataZapisu() {
        return dataZapisu;
    }

    public String getStatus() {
        return status;
    }

    public Student getStudent() {
        return student;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    // ===================== SETTERY =====================

    public void setZapisId(Integer zapisId) {
        this.zapisId = zapisId;
    }

    public void setDataZapisu(LocalDate dataZapisu) {
        this.dataZapisu = dataZapisu;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }
}