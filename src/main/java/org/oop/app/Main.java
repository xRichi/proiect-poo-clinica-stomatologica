package org.oop.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Specializare generala = new Specializare(1, "Stomatologie generala", 150.0);
        Specializare endodontie = new Specializare(2, "Endodontie", 200.0);
        Specializare protetica = new Specializare(3, "Protetica", 200.0);

        Medic popa = new Medic(1, "Dr. Andrei Popa", generala);
        Medic marin = new Medic(2, "Dr. Ioana Marin", endodontie);
        Medic stan = new Medic(3, "Dr. Radu Stan", protetica);

        Tratament detartraj = new Tratament(1, "Detartraj si periaj profesional", 250.0, generala);
        Tratament obturatie = new Tratament(2, "Obturatie compozit", 350.0, generala);
        Tratament tratamentCanal = new Tratament(3, "Tratament de canal", 600.0, endodontie);
        Tratament coroana = new Tratament(4, "Coroana ceramica", 1500.0, protetica);

        Pacient ana = new Pacient(1, "Ana Popescu", "0740111222", 28);
        ana.setEmail("ana.popescu@email.ro");
        Pacient mihai = new Pacient(2, "Mihai Ionescu", "0751333444", 45);
        Pacient elena = new Pacient(3, "Elena Rusu", "0762555666", 63);

        System.out.println("=== PROGRAMARI ===");
        Programare p1 = new Programare(1, ana, popa, LocalDate.of(2026, 11, 18), "10:00");
        p1.adaugaTratament(detartraj);
        p1.adaugaTratament(obturatie);
        p1.adaugaTratament(tratamentCanal);
        p1.setDecontare(new PlataIntegrala(1));

        Programare p2 = new Programare(2, mihai, marin, LocalDate.of(2026, 11, 18), "12:30");
        p2.adaugaTratament(tratamentCanal);
        p2.setDecontare(new DecontareCAS(2, 300.0));

        Programare p3 = new Programare(3, elena, stan, LocalDate.of(2026, 11, 19), "09:00");
        p3.adaugaTratament(coroana);
        p3.adaugaTratament(coroana);
        p3.setDecontare(new AsigurarePrivata(3, "Signal Iduna", 70.0));

        List<Programare> programari = new ArrayList<>();
        programari.add(p1);
        programari.add(p2);
        programari.add(p3);

        System.out.println();
        for (Programare p : programari)
            System.out.println(p.getDetalii());

        System.out.println("\n=== FACTURI ===");
        List<Factura> facturi = new ArrayList<>();
        int numar = 2001;
        for (Programare p : programari)
            facturi.add(new Factura("DENT", numar++, p));
        facturi.get(0).achita();
        facturi.get(2).achita();
        for (Factura f : facturi)
            System.out.println(f.getDetalii());

        System.out.println("\n=== RAPORT ===");
        Double totalServicii = 0.0, incasatPacienti = 0.0, deLaCAS = 0.0, deLaAsiguratori = 0.0, restante = 0.0;
        for (Factura f : facturi) {
            Programare p = f.getProgramare();
            totalServicii += f.getTotal();
            incasatPacienti += f.isAchitata() ? f.getSumaPacient() : 0.0;
            restante += f.isAchitata() ? 0.0 : f.getSumaPacient();
            if (p.getDecontare() instanceof DecontareCAS)
                deLaCAS += f.getSumaDecontata();
            if (p.getDecontare() instanceof AsigurarePrivata)
                deLaAsiguratori += f.getSumaDecontata();
        }
        System.out.printf("Valoare servicii: %.2f lei%n", totalServicii);
        System.out.printf("Incasat de la pacienti: %.2f lei%n", incasatPacienti);
        System.out.printf("Neincasat de la pacienti: %.2f lei%n", restante);
        System.out.printf("De decontat de la CAS: %.2f lei%n", deLaCAS);
        System.out.printf("De decontat de la asiguratori privati: %.2f lei%n", deLaAsiguratori);

        System.out.println("\n=== toString() generat de Lombok ===");
        System.out.println(marin);
        System.out.println(p3.getDecontare());
    }
}
