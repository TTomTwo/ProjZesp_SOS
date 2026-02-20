package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String haslo; // hashed!

    @Column(unique = true, nullable = false)
    private String nrIndeksu;

    private LocalDate dataRejestracji = LocalDate.now();

    // Gettery i settery (wygeneruj Alt+Insert → Getter and Setter)
    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }
    // ... reszta
}