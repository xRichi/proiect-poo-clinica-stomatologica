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

---

# Ghid de instalare pas cu pas

Ghidul merge atât pe **Windows**, cât și pe **macOS**. Durează cam 10–15 minute, cel mai mult ține descărcarea programelor.

## Pasul 1 – Instalează IntelliJ IDEA

1. Intră pe https://www.jetbrains.com/idea/download/
2. Alege sistemul tău (Windows / macOS) și descarcă **IntelliJ IDEA**. Varianta gratuită e suficientă.
3. Instalează-l ca pe orice program (pe Windows: Next → Next → Install; pe Mac: tragi aplicația în Applications).
4. Deschide IntelliJ. La primul start poți sări peste toate întrebările (Skip / Next).

> Nu trebuie să instalezi Java separat: IntelliJ îl descarcă singur la Pasul 3.

## Pasul 2 – Descarcă proiectul

**Varianta A – direct din IntelliJ (recomandat):**
1. Pe ecranul de start apasă **Clone Repository** (sau din meniu: **File → New → Project from Version Control**).
2. La **URL** lipește:
   ```
   https://github.com/xRichi/proiect-poo-clinica-stomatologica.git
   ```
3. Alege unde să-l salveze și apasă **Clone**.
4. Dacă îți spune că Git nu e instalat, apasă **Download and Install** și apoi încearcă din nou.
5. La întrebarea „Trust project?” apasă **Trust Project**.

**Varianta B – fără Git, cu ZIP:**
1. Pe pagina proiectului de pe GitHub apasă butonul verde **Code → Download ZIP**.
2. Dezarhivează ZIP-ul (click dreapta → Extract All pe Windows; dublu-click pe Mac).
3. În IntelliJ: **File → Open** și alege folderul dezarhivat (cel care conține `pom.xml`). Apasă **Trust Project**.

## Pasul 3 – Setează Java (JDK 21)

1. Apasă **Ctrl + Alt + Shift + S** (Windows) sau **⌘ ;** (Mac) – se deschide **Project Structure**.
2. În stânga alege **Project**.
3. La **SDK**:
   - dacă apare deja un JDK 21, alege-l;
   - dacă nu, alege **Download JDK…** → Version **21** → Vendor oricare (ex. *Microsoft OpenJDK* sau *Eclipse Temurin*) → **Download**.
4. La **Language level** alege **21**.
5. Apasă **OK**.

## Pasul 4 – Încarcă dependențele (Lombok)

1. În dreapta sus apare o iconiță mică cu **„m”** sau un mesaj **Load Maven Changes** – apasă pe ea.
   Dacă nu apare: în bara din dreapta deschide fereastra **Maven** și apasă butonul de **Reload** (săgețile în cerc).
2. Așteaptă să termine bara de progres de jos.
3. Dacă apare mesajul **„Lombok requires enabled annotation processing”**, apasă **Enable annotation processing**.

## Pasul 5 – Rulează proiectul

1. În stânga, în fereastra **Project**, deschide:
   `src → main → java → org.oop.app → Main`
2. Apasă triunghiul verde ▶ de lângă `public class Main` și alege **Run 'Main.main()'**.
3. Jos se deschide consola cu programările, facturile și raportul. Dacă la final scrie **Process finished with exit code 0**, totul a mers.

## Probleme frecvente

| Eroare | Rezolvare |
|---|---|
| `JDK isn't specified for module` | Refă **Pasul 3** (Project Structure → SDK 21). Apoi în **Modules → Dependencies** pune Module SDK pe *Project SDK*. |
| `cannot find symbol` la `getNume()`, `setDecontare()` etc. | Lombok nu e activ: refă **Pasul 4**, apoi **Build → Rebuild Project**. Verifică și **Settings → Build, Execution, Deployment → Compiler → Annotation Processors → Enable annotation processing** (bifat). |
| `package lombok does not exist` | Maven nu a descărcat dependențele: fereastra **Maven → Reload**. Ai nevoie de internet. |
| Nu apare triunghiul verde ▶ | Proiectul nu e recunoscut ca Maven: click dreapta pe `pom.xml` → **Add as Maven Project**. |
| `release version 21 not supported` | JDK-ul ales e mai vechi de 21: refă **Pasul 3** cu JDK 21. |
