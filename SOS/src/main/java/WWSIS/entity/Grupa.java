package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "grupa")
public class Grupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grupaId;

    @Column(nullable = false)
    private String nazwa;

    private int limitMiejsc;

    private String sala;

    public Integer getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(Integer grupaId) {
        this.grupaId = grupaId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLimitMiejsc() {
        return limitMiejsc;
    }

    public void setLimitMiejsc(int limitMiejsc) {
        this.limitMiejsc = limitMiejsc;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public LocalTime getGodzinaOd() {
        return godzinaOd;
    }

    public void setGodzinaOd(LocalTime godzinaOd) {
        this.godzinaOd = godzinaOd;
    }

    public LocalTime getGodzinaDo() {
        return godzinaDo;
    }

    public void setGodzinaDo(LocalTime godzinaDo) {
        this.godzinaDo = godzinaDo;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public List<Zapis> getZapisy() {
        return zapisy;
    }

    public void setZapisy(List<Zapis> zapisy) {
        this.zapisy = zapisy;
    }

    private LocalTime godzinaOd;

    private LocalTime godzinaDo;

    @ManyToOne
    @JoinColumn(name = "przedmiot_id")
    private Przedmiot przedmiot;

    @OneToMany(mappedBy = "grupa")
    private List<Zapis> zapisy;

    // gettery i settery
}