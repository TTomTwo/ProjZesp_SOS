package WWSIS.dao;

import WWSIS.entity.Zapis;
import java.util.List;

public interface ZapisDao {

    // Pobierz zapis po ID
    Zapis pobierzZapis(Integer id);

    // Pobierz wszystkie zapisy studenta
    List<Zapis> pobierzZapisyStudenta(Integer studentId);

    // Pobierz wszystkie zapisy na grupę
    List<Zapis> pobierzZapisyNaGrupe(Integer grupaId);

    // Pobierz aktywne zapisy studenta (status = "zapisany")
    List<Zapis> pobierzAktywneZapisyStudenta(Integer studentId);

    // Zapisz lub zaktualizuj zapis
    void zapiszZapis(Zapis zapis);

    // Anuluj zapis (zmień status na "wypisany")
    void anulujZapis(Integer zapisId);

    // Usuń zapis
    void usunZapis(Integer zapisId);
}