package WWSIS.dao;

import WWSIS.entity.Grupa;
import WWSIS.entity.Przedmiot;
import java.util.List;

public interface PrzedmiotDao {

    // Pobierz przedmiot po ID
    Przedmiot pobierzPrzedmiot(Integer id);

    // Pobierz wszystkie przedmioty
    List<Przedmiot> pobierzWszystkiePrzedmioty();

    // Pobierz opis przedmiotu
    String pobierzOpisPrzedmiotu(Integer przedmiotId);

    // Pobierz grupy dla danego przedmiotu
    List<Grupa> pobierzGrupyPrzedmiotu(Integer przedmiotId);

    // Zapisz lub zaktualizuj przedmiot
    void zapiszPrzedmiot(Przedmiot przedmiot);

    // Usuń przedmiot
    void usunPrzedmiot(Integer id);
}