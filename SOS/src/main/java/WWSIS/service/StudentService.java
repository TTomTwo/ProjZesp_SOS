package WWSIS.service;

import WWSIS.entity.Student;
import WWSIS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // Wstrzykiwanie zależności do repozytorium studenta
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Metoda zapisuje studenta do bazy danych.
     * Jeżeli student o podanych danych już istnieje, zostanie zaktualizowany,
     * w przeciwnym przypadku zostanie dodany jako nowy.
     *
     * @param student obiekt studenta, który ma zostać zapisany
     * @return zapisany (lub zaktualizowany) obiekt studenta
     */
    public Student zapiszStudenta(Student student) {
        // Zapisuje studenta do bazy danych za pomocą repozytorium
        return studentRepository.save(student);
    }

    /**
     * Metoda znajduje studenta po jego adresie email.
     * Jeśli student o podanym adresie email istnieje, zostanie zwrócony,
     * w przeciwnym przypadku zwróci null.
     *
     * @param email adres email studenta
     * @return znaleziony student lub null jeśli nie znaleziono
     */
    public Student znajdzPoEmail(String email) {
        // Wyszukuje studenta w bazie danych po jego adresie email
        return studentRepository.findByEmail(email);
    }
}