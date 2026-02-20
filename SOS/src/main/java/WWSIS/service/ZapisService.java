package WWSIS.service;

import WWSIS.entity.Grupa;
import WWSIS.entity.Student;
import WWSIS.entity.Zapis;
import WWSIS.repository.GrupaRepository;
import WWSIS.repository.ZapisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ZapisService {

    @Autowired
    private ZapisRepository zapisRepository;

    @Autowired
    private GrupaRepository grupaRepository;

    /**
     * Próbuje zapisać studenta na grupę.
     * Zwraca true jeśli zapis się udał, false jeśli nie (brak miejsc / poza terminem / konflikt / brak uprawnień).
     */
    public boolean zapiszNaGrupe(Student student, Integer grupaId) {
        Grupa grupa = grupaRepository.findById(grupaId)
                .orElseThrow(() -> new RuntimeException("Grupa o ID " + grupaId + " nie istnieje"));

        // 1. Termin zapisów (na razie zawsze OK – dodaj logikę kiedy chcesz)
        if (!czyWTerminieZapisy()) {
            return false;
        }

        // 2. Brak miejsc
        int aktualnaLiczbaZapisy = liczbaZapisyNaGrupe(grupa);
        if (grupa.getLimitMiejsc() <= aktualnaLiczbaZapisy) {
            return false;
        }

        // 3. Konflikt w planie (na razie zawsze OK)
        if (czyKonfliktWPlanie(student, grupa)) {
            return false;
        }

        // 4. Uprawnienia wstępne (na razie zawsze OK)
        if (!czyMaUprawnienia(student, grupa)) {
            return false;
        }

        // Zapisujemy
        Zapis zapis = new Zapis();
        zapis.setStudent(student);
        zapis.setGrupa(grupa);
        zapis.setDataZapisu(LocalDate.now());
        zapis.setStatus("zapisany");

        zapisRepository.save(zapis);

        return true;
    }

    private boolean czyWTerminieZapisy() {
        // TODO: sprawdź aktualną datę względem terminów zapisów (np. z bazy lub configu)
        return true;
    }

    private int liczbaZapisyNaGrupe(Grupa grupa) {
        // Zlicz tylko aktywne zapisy (status = "zapisany")
        return (int) zapisRepository.findAll().stream()
                .filter(z -> z.getGrupa().getGrupaId().equals(grupa.getGrupaId()))
                .filter(z -> "zapisany".equals(z.getStatus()))
                .count();
    }

    private boolean czyKonfliktWPlanie(Student student, Grupa nowaGrupa) {
        // TODO: pobierz plan studenta i sprawdź kolizje godzin z nową grupą
        // np. pobierz wszystkie grupy studenta → porównaj godziny
        return false;
    }

    private boolean czyMaUprawnienia(Student student, Grupa grupa) {
        // TODO: sprawdź wymagania wstępne (np. zaliczone przedmioty, kierunek itd.)
        return true;
    }
}