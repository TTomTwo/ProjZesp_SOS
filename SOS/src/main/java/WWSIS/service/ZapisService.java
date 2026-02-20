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

    // Autowire zależności do repozytoriów, które pozwolą na operacje na encjach Grupa i Zapis.
    @Autowired
    private ZapisRepository zapisRepository;

    @Autowired
    private GrupaRepository grupaRepository;

    /**
     * Próbuje zapisać studenta na grupę.
     * Zwraca true jeśli zapis się udał, false jeśli nie (np. brak miejsc / poza terminem / konflikt / brak uprawnień).
     */
    public boolean zapiszNaGrupe(Student student, Integer grupaId) {
        // Sprawdzenie, czy grupa o podanym ID istnieje w bazie
        Grupa grupa = grupaRepository.findById(grupaId)
                .orElseThrow(() -> new RuntimeException("Grupa o ID " + grupaId + " nie istnieje"));

        // 1. Sprawdzenie terminu zapisów
        // Na razie ta logika zawsze zwraca 'true', ale można ją zaimplementować w przyszłości.
        if (!czyWTerminieZapisy()) {
            return false;  // Zapis nie możliwy, jeśli nie jest w terminie
        }

        // 2. Sprawdzenie liczby zapisów na grupie
        // Sprawdzamy, czy grupa nie jest pełna
        int aktualnaLiczbaZapisy = liczbaZapisyNaGrupe(grupa);
        if (grupa.getLimitMiejsc() <= aktualnaLiczbaZapisy) {
            return false;  // Brak miejsc, zapis nie możliwy
        }

        // 3. Sprawdzenie konfliktów w planie zajęć studenta
        // Na razie ta logika zawsze zwraca 'false', ale można ją zaimplementować w przyszłości.
        if (czyKonfliktWPlanie(student, grupa)) {
            return false;  // Konflikt w planie zajęć studenta
        }

        // 4. Sprawdzenie uprawnień wstępnych (np. wymagane przedmioty lub kierunek studiów)
        // Na razie ta logika zawsze zwraca 'true', ale można ją zaimplementować w przyszłości.
        if (!czyMaUprawnienia(student, grupa)) {
            return false;  // Student nie spełnia wymagań wstępnych
        }

        // Jeśli wszystkie warunki zostały spełnione, zapisujemy studenta na grupę
        Zapis zapis = new Zapis();
        zapis.setStudent(student);  // Ustawiamy studenta w zapisie
        zapis.setGrupa(grupa);      // Ustawiamy grupę w zapisie
        zapis.setDataZapisu(LocalDate.now());  // Ustawiamy datę zapisu na dzisiaj
        zapis.setStatus("zapisany");  // Status zapisu (np. "zapisany", "oczekujący", etc.)

        zapisRepository.save(zapis);  // Zapisujemy nowy zapis w bazie danych

        return true;  // Zapis został pomyślnie zapisany
    }

    /**
     * Metoda sprawdzająca, czy zapis odbywa się w wyznaczonym terminie.
     * Na razie zawsze zwraca true.
     */
    private boolean czyWTerminieZapisy() {
        // TODO: Sprawdzanie daty zapisu względem dostępnych terminów zapisów (np. z bazy lub pliku konfiguracyjnego)
        return true;  // Na razie zakłada, że zapis jest zawsze możliwy
    }

    /**
     * Metoda zliczająca liczbę zapisanych studentów na danej grupie.
     * Liczymy tylko zapisy o statusie "zapisany".
     */
    private int liczbaZapisyNaGrupe(Grupa grupa) {
        // Zliczamy zapisy w repozytorium, które należą do podanej grupy
        return (int) zapisRepository.findAll().stream()
                .filter(z -> z.getGrupa().getGrupaId().equals(grupa.getGrupaId()))  // Filtrujemy po ID grupy
                .filter(z -> "zapisany".equals(z.getStatus()))  // Tylko zapisy o statusie "zapisany"
                .count();  // Liczymy zapisy
    }

    /**
     * Metoda sprawdzająca, czy zapis na grupę nie koliduje z planem studenta.
     * Na razie ta logika jest zawsze OK, ale można ją rozbudować o szczegóły.
     */
    private boolean czyKonfliktWPlanie(Student student, Grupa nowaGrupa) {
        // TODO: Pobierz plan zajęć studenta i porównaj godziny z planem zajęć nowej grupy.
        // Można zaimplementować logikę, która sprawdzi kolizję godzin zajęć.
        return false;  // Na razie zakładamy brak konfliktu
    }

    /**
     * Metoda sprawdzająca, czy student spełnia wymagania wstępne do zapisania się na grupę.
     * Na razie ta logika jest zawsze OK, ale można ją rozbudować o wymagania, takie jak
     * zaliczone przedmioty czy kierunek studiów.
     */
    private boolean czyMaUprawnienia(Student student, Grupa grupa) {
        // TODO: Sprawdzenie wymagań wstępnych, np. czy student zaliczył wymagane przedmioty
        return true;  // Na razie zakładamy, że student zawsze ma uprawnienia
    }
}