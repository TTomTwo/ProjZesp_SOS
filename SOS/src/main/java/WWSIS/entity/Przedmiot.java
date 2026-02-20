package WWSIS.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "przedmiot")
public class Przedmiot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer przedmiotId;

    public Integer getPrzedmiotId() {
        return przedmiotId;
    }

    public void setPrzedmiotId(Integer przedmiotId) {
        this.przedmiotId = przedmiotId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public List<Grupa> getGrupy() {
        return grupy;
    }

    public void setGrupy(List<Grupa> grupy) {
        this.grupy = grupy;
    }

    @Column(nullable = false)
    private String nazwa;

    private String opis;

    private int ects;

    private String prowadzacy;

    @OneToMany(mappedBy = "przedmiot")
    private List<Grupa> grupy;

    // gettery i settery (Alt+Insert → Getter and Setter)
}