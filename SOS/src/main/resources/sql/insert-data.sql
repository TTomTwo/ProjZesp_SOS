-- ============================================================
-- SOS - System Obslugi Studenta
-- insert-data.sql (NAPRAWIONY - jawne ID)
-- Plik: src/main/resources/sql/insert-data.sql
-- ============================================================

-- Studenci
INSERT INTO student (id, imie, nazwisko, email, haslo, nr_indeksu, data_rejestracji) VALUES
                                                                                         (1, 'Jan',    'Kowalski',   'jan.kowalski@student.wwsis.pl',   '$2a$10$hashedpassword1', 'S12345', '2024-10-01'),
                                                                                         (2, 'Anna',   'Nowak',      'anna.nowak@student.wwsis.pl',     '$2a$10$hashedpassword2', 'S12346', '2024-10-01'),
                                                                                         (3, 'Piotr',  'Wisniewski', 'piotr.wisniewski@student.wwsis.pl','$2a$10$hashedpassword3','S12347', '2024-10-02'),
                                                                                         (4, 'Marta',  'Wojcik',     'marta.wojcik@student.wwsis.pl',   '$2a$10$hashedpassword4', 'S12348', '2024-10-02'),
                                                                                         (5, 'Tomasz', 'Kaminski',   'tomasz.kaminski@student.wwsis.pl','$2a$10$hashedpassword5', 'S12349', '2024-10-03');

-- Przedmioty
INSERT INTO przedmiot (przedmiot_id, nazwa, opis, ects, prowadzacy) VALUES
                                                                        (1, 'Programowanie w Javie',    'Podstawy i zaawansowane techniki programowania w jezyku Java', 6, 'dr Cezary Holub'),
                                                                        (2, 'Bazy Danych',              'Projektowanie i implementacja relacyjnych baz danych',          5, 'dr Anna Kowalczyk'),
                                                                        (3, 'Sieci Komputerowe',        'Protokoly, topologie i bezpieczenstwo sieci',                   4, 'mgr Piotr Nowak'),
                                                                        (4, 'Algorytmy i Struktury',    'Analiza zlozonosci i implementacja algorytmow',                 6, 'dr hab. Marek Zielinski'),
                                                                        (5, 'Inzynieria Oprogramowania','Metodyki wytwarzania oprogramowania, wzorce projektowe',        5, 'dr Cezary Holub');

-- Grupy
INSERT INTO grupa (grupa_id, nazwa, limit_miejsc, sala, godzina_od, godzina_do, przedmiot_id) VALUES
                                                                                                  (1, 'Java-A', 25, 'LAB01', '08:00:00', '09:30:00', 1),
                                                                                                  (2, 'Java-B', 25, 'LAB02', '10:00:00', '11:30:00', 1),
                                                                                                  (3, 'BD-A',   20, 'LAB03', '12:00:00', '13:30:00', 2),
                                                                                                  (4, 'BD-B',   20, 'LAB04', '14:00:00', '15:30:00', 2),
                                                                                                  (5, 'SK-A',   30, 'SALA1', '08:00:00', '09:30:00', 3);

-- Plan zajec
INSERT INTO plan_zajec (plan_id, dzien_tygodnia, godzina_od, godzina_do, sala, grupa_id) VALUES
                                                                                             (1, 'Poniedzialek', '08:00:00', '09:30:00', 'LAB01', 1),
                                                                                             (2, 'Sroda',        '10:00:00', '11:30:00', 'LAB02', 2),
                                                                                             (3, 'Wtorek',       '12:00:00', '13:30:00', 'LAB03', 3),
                                                                                             (4, 'Czwartek',     '14:00:00', '15:30:00', 'LAB04', 4),
                                                                                             (5, 'Piatek',       '08:00:00', '09:30:00', 'SALA1', 5);

-- Zapisy
INSERT INTO zapis (zapis_id, data_zapisu, status, student_id, grupa_id) VALUES
                                                                            (1, '2024-10-05', 'zapisany', 1, 1),
                                                                            (2, '2024-10-05', 'zapisany', 1, 3),
                                                                            (3, '2024-10-06', 'zapisany', 2, 1),
                                                                            (4, '2024-10-06', 'zapisany', 2, 4),
                                                                            (5, '2024-10-07', 'zapisany', 3, 2),
                                                                            (6, '2024-10-07', 'wypisany', 3, 3),
                                                                            (7, '2024-10-08', 'zapisany', 4, 3),
                                                                            (8, '2024-10-08', 'zapisany', 5, 5);

-- Oceny
INSERT INTO ocena (ocena_id, wartosc, data_wystawienia, student_id, przedmiot_id) VALUES
                                                                                      (1, 5.0, '2025-01-20', 1, 1),
                                                                                      (2, 4.0, '2025-01-20', 1, 2),
                                                                                      (3, 3.5, '2025-01-21', 2, 1),
                                                                                      (4, 4.5, '2025-01-21', 2, 2),
                                                                                      (5, 3.0, '2025-01-22', 3, 1),
                                                                                      (6, 5.0, '2025-01-22', 4, 2),
                                                                                      (7, 2.0, '2025-01-23', 5, 3);

-- Oplaty
INSERT INTO oplata (oplata_id, kwota, data_platnosci, typ, status, student_id) VALUES
                                                                                   (1, 1200.00, '2024-10-10', 'czesne',      'oplacone',   1),
                                                                                   (2, 1200.00, '2024-10-11', 'czesne',      'oplacone',   2),
                                                                                   (3, 1200.00, NULL,         'czesne',      'nieoplacone', 3),
                                                                                   (4,   50.00, '2024-10-12', 'legitymacja', 'oplacone',   1),
                                                                                   (5, 1200.00, '2024-10-10', 'czesne',      'oplacone',   4),
                                                                                   (6, 1200.00, NULL,         'czesne',      'nieoplacone', 5);

-- Wypozyczenia ksiazek
INSERT INTO wypozyczenie_ksiazki (wypozyczenie_id, tytul, data_wypozyczenia, data_zwrotu, status, student_id) VALUES
                                                                                                                  (1, 'Effective Java',             '2024-11-01', '2024-12-01', 'zwrocona',        1),
                                                                                                                  (2, 'Clean Code',                 '2024-11-15', NULL,         'wypozyczona',     2),
                                                                                                                  (3, 'Design Patterns',            '2024-10-01', '2024-11-01', 'przeterminowana', 3),
                                                                                                                  (4, 'Java Concurrency in Practice','2024-12-01', NULL,        'wypozyczona',     1),
                                                                                                                  (5, 'Spring in Action',           '2024-11-20', NULL,         'wypozyczona',     4);