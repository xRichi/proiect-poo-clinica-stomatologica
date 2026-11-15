# Proiect POO – Clinică stomatologică

Proiect Java (Maven + Lombok) pentru disciplina Programare Orientată Obiect, FEAA UAIC, anul 3, sem. 1.

Sistemul modelează activitatea unei clinici stomatologice: pacienți, medici pe specializări, tratamente, programări, facturi și modul de decontare a costurilor.

## Clase
- `Specializare`, `Medic`, `Pacient`, `Tratament`
- `Programare` – pacient, medic, tratamente efectuate, decontare; calculează valoarea totală și suma de plată
- `Decontare` (abstractă) → `PlataIntegrala`, `DecontareCAS` (plafon decontat), `AsigurarePrivata` (procent acoperit)
- `Factura` – total, sumă decontată, sumă de plată pacient
- `Main` – scenariu de test cu 3 programări, facturi și raport

## Rulare
Java 21, Maven. Din IntelliJ: rulează `org.oop.app.Main`.
