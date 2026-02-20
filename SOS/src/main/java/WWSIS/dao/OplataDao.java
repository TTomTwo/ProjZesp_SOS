package WWSIS.dao;

import WWSIS.entity.Oplata;
import java.util.List;

public interface OplataDao {

    // Pobierz opłatę po ID
    Oplata pobierzOplate(Integer id);

    // Pobierz wszystkie opłaty studenta
    List<Oplata> pobierzWszystkieOplatyStudenta(Integer studentId);

    // Pobierz zaległe opłaty studenta (status = "nieoplacone")
    List<Oplata> pobierzZalegleOplatyStudenta(Integer studentId);

    // Zapisz lub zaktualizuj opłatę
    void zapiszOplate(Oplata oplata);
}