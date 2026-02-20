package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wypozyczenie_ksiazki")
public class WypozyczenieKsiazki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wypozyczenieId;

    @Column(nullable = false)
    private String tytul;

    private LocalDate dataWypozyczenia;

    private LocalDate dataZwrotu;

    private String status; // "wypozyczona", "zwrocona", "przeterminowana"

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // GETTERY
    public Integer getWypozyczenieId() { return wypozyczenieId; }
    public String getTytul() { return tytul; }
    public LocalDate getDataWypozyczenia() { return dataWypozyczenia; }
    public LocalDate getDataZwrotu() { return dataZwrotu; }
    public String getStatus() { return status; }
    public Student getStudent() { return student; }

    // SETTERY
    public void setWypozyczenieId(Integer wypozyczenieId) { this.wypozyczenieId = wypozyczenieId; }
    public void setTytul(String tytul) { this.tytul = tytul; }
    public void setDataWypozyczenia(LocalDate dataWypozyczenia) { this.dataWypozyczenia = dataWypozyczenia; }
    public void setDataZwrotu(LocalDate dataZwrotu) { this.dataZwrotu = dataZwrotu; }
    public void setStatus(String status) { this.status = status; }
    public void setStudent(Student student) { this.student = student; }
}