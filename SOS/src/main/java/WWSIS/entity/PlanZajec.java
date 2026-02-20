package WWSIS.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "plan_zajec")
public class PlanZajec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @Column(nullable = false)
    private String dzienTygodnia; // "Poniedzialek", "Wtorek" itd.

    private LocalTime godzinaOd;

    private LocalTime godzinaDo;

    private String sala;

    @ManyToOne
    @JoinColumn(name = "grupa_id", nullable = false)
    private Grupa grupa;

    // GETTERY
    public Integer getPlanId() { return planId; }
    public String getDzienTygodnia() { return dzienTygodnia; }
    public LocalTime getGodzinaOd() { return godzinaOd; }
    public LocalTime getGodzinaDo() { return godzinaDo; }
    public String getSala() { return sala; }
    public Grupa getGrupa() { return grupa; }

    // SETTERY
    public void setPlanId(Integer planId) { this.planId = planId; }
    public void setDzienTygodnia(String dzienTygodnia) { this.dzienTygodnia = dzienTygodnia; }
    public void setGodzinaOd(LocalTime godzinaOd) { this.godzinaOd = godzinaOd; }
    public void setGodzinaDo(LocalTime godzinaDo) { this.godzinaDo = godzinaDo; }
    public void setSala(String sala) { this.sala = sala; }
    public void setGrupa(Grupa grupa) { this.grupa = grupa; }
}