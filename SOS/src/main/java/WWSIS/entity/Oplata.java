package WWSIS.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "oplata")
public class Oplata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oplataId;

    @Column(nullable = false)
    private BigDecimal kwota;

    private LocalDate dataPlatnosci;

    private String typ; // np. "czesne", "legitymacja", "dyplom"

    private String status; // "oplacone", "nieoplacone"

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // GETTERY
    public Integer getOplataId() { return oplataId; }
    public BigDecimal getKwota() { return kwota; }
    public LocalDate getDataPlatnosci() { return dataPlatnosci; }
    public String getTyp() { return typ; }
    public String getStatus() { return status; }
    public Student getStudent() { return student; }

    // SETTERY
    public void setOplataId(Integer oplataId) { this.oplataId = oplataId; }
    public void setKwota(BigDecimal kwota) { this.kwota = kwota; }
    public void setDataPlatnosci(LocalDate dataPlatnosci) { this.dataPlatnosci = dataPlatnosci; }
    public void setTyp(String typ) { this.typ = typ; }
    public void setStatus(String status) { this.status = status; }
    public void setStudent(Student student) { this.student = student; }
}