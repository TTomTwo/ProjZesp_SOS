package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ocena")
public class Ocena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ocenaId;

    @Column(nullable = false)
    private Float wartosc; // np. 2.0, 3.0, 3.5, 4.0, 4.5, 5.0

    private LocalDate dataWystawienia;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "przedmiot_id", nullable = false)
    private Przedmiot przedmiot;

    // GETTERY
    public Integer getOcenaId() { return ocenaId; }
    public Float getWartosc() { return wartosc; }
    public LocalDate getDataWystawienia() { return dataWystawienia; }
    public Student getStudent() { return student; }
    public Przedmiot getPrzedmiot() { return przedmiot; }

    // SETTERY
    public void setOcenaId(Integer ocenaId) { this.ocenaId = ocenaId; }
    public void setWartosc(Float wartosc) { this.wartosc = wartosc; }
    public void setDataWystawienia(LocalDate dataWystawienia) { this.dataWystawienia = dataWystawienia; }
    public void setStudent(Student student) { this.student = student; }
    public void setPrzedmiot(Przedmiot przedmiot) { this.przedmiot = przedmiot; }
}