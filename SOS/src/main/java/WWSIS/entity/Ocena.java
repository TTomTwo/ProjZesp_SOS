package WWSIS.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ocena") // Określenie nazwy tabeli w bazie danych, której ta encja dotyczy
public class Ocena {

    // Określenie identyfikatora encji, który będzie kluczem głównym w tabeli "ocena"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Klucz główny generowany przez bazę danych (autoinkrementacja)
    private Integer ocenaId;

    // ===================== GETTERY =====================

    // Getter dla pola ocenaId
    public Integer getOcenaId() {
        return ocenaId;
    }

    // Getter dla pola wartosc (wartość oceny, np. 2.0, 3.0, 4.5)
    public Float getWartosc() {
        return wartosc;
    }

    // Getter dla pola dataWystawienia (data, kiedy ocena została wystawiona)
    public LocalDate getDataWystawienia() {
        return dataWystawienia;
    }

    // Getter dla pola student (relacja z encją Student, wskazuje na studenta, któremu wystawiono ocenę)
    public Student getStudent() {
        return student;
    }

    // Getter dla pola przedmiot (relacja z encją Przedmiot, wskazuje na przedmiot, do którego przypisana jest ocena)
    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    // ===================== SETTERY =====================

    // Setter dla pola ocenaId
    public void setOcenaId(Integer ocenaId) {
        this.ocenaId = ocenaId;
    }

    // Setter dla pola wartosc (ustawia wartość oceny)
    public void setWartosc(Float wartosc) {
        this.wartosc = wartosc;
    }

    // Setter dla pola dataWystawienia (ustawia datę wystawienia oceny)
    public void setDataWystawienia(LocalDate dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    // Setter dla pola student (ustawia relację z encją Student)
    public void setStudent(Student student) {
        this.student = student;
    }

    // Setter dla pola przedmiot (ustawia relację z encją Przedmiot)
    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    // ===================== POLE =====================

    @Column(nullable = false) // Wartość oceny, nie może być pusta
    private Float wartosc;

    private LocalDate dataWystawienia; // Data, kiedy ocena została wystawiona

    // Relacja wielu do jednego z encją Student (jeden student może mieć wiele ocen)
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false) // Powiązanie z tabelą "student", kolumna "student_id"
    private Student student; // Student, któremu została wystawiona ocena

    // Relacja wielu do jednego z encją Przedmiot (jeden przedmiot może mieć wiele ocen)
    @ManyToOne
    @JoinColumn(name = "przedmiot_id", nullable = false) // Powiązanie z tabelą "przedmiot", kolumna "przedmiot_id"
    private Przedmiot przedmiot; // Przedmiot, do którego przypisana jest ta ocena

}