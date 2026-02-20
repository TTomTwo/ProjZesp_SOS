package WWSIS.dao;

import WWSIS.entity.WypozyczenieKsiazki;
import java.util.List;

public interface WypozyczenieDao {

    // Pobierz wypożyczenie po ID
    WypozyczenieKsiazki pobierzWypozyczenie(Integer id);

    // Pobierz wszystkie wypożyczenia studenta
    List<WypozyczenieKsiazki> pobierzWypozyczeniaStudenta(Integer studentId);

    // Pobierz aktywne wypożyczenia studenta (status = "wypozyczona")
    List<WypozyczenieKsiazki> pobierzAktywneWypozyczenia(Integer studentId);

    // Pobierz przeterminowane wypożyczenia studenta
    List<WypozyczenieKsiazki> pobierzPrzeterminowane(Integer studentId);

    // Zapisz lub zaktualizuj wypożyczenie
    void zapiszWypozyczenie(WypozyczenieKsiazki wypozyczenie);
}