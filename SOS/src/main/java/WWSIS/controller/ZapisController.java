package WWSIS.controller;

import WWSIS.service.ZapisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zapisy")
public class ZapisController {

    @Autowired
    private ZapisService zapisService;

    @PostMapping
    public ResponseEntity<String> zapiszNaGrupe(@RequestParam Integer grupaId, @RequestParam Integer studentId) {
        // Na razie proste – w realu weź z autentykacji
        // Tutaj założenie, że masz studenta i grupę po ID
        boolean sukces = zapisService.zapiszNaGrupe(
                /* student po ID - TODO: pobrać z autentykacji / SecurityContext */
                null,
                grupaId
        );
        if (sukces) {
            return ResponseEntity.ok("Zapisano pomyślnie");
        } else {
            return ResponseEntity.badRequest().body("Nie udało się zapisać (brak miejsc/konflikt/termin)");
        }
    }
}