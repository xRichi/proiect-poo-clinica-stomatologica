package org.oop.app;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public class Programare {
    @EqualsAndHashCode.Include
    @NonNull private Integer idProgramare;
    @NonNull private Pacient pacient;
    @NonNull private Medic medic;
    @NonNull private LocalDate data;
    @NonNull private String ora;
    private List<Tratament> tratamente = new ArrayList<>();
    private Decontare decontare;

    public boolean adaugaTratament(Tratament tratament) {
        if (!tratament.getSpecializare().equals(medic.getSpecializare())) {
            System.out.println(medic.getNume() + " (" + medic.getSpecializare().getDenumire()
                    + ") nu poate efectua: " + tratament.getDenumire());
            return false;
        }
        tratamente.add(tratament);
        return true;
    }

    public Double getTarifConsultatie() {
        return medic.getSpecializare().getTarifConsultatie();
    }

    public Double getValoareTratamente() {
        Double total = 0.0;
        for (Tratament tratament : tratamente)
            total += tratament.getPret();
        return total;
    }

    public Double getValoareTotala() {
        return getTarifConsultatie() + getValoareTratamente();
    }

    public Double getSumaAcoperita() {
        if (decontare == null)
            return 0.0;
        return decontare.getSumaAcoperita(getValoareTotala());
    }

    public Double getSumaDePlata() {
        if (decontare == null)
            return getValoareTotala();
        return decontare.getSumaDePlataPacient(getValoareTotala());
    }

    public String getDetalii() {
        String text = "Programarea #" + idProgramare + " din " + data + " ora " + ora + " - "
                + pacient.getNume() + " la " + medic.getNume() + " (" + medic.getSpecializare().getDenumire() + ")\n";
        text += String.format("   Consultatie = %.2f lei%n", getTarifConsultatie());
        for (Tratament tratament : tratamente)
            text += String.format("   %s = %.2f lei%n", tratament.getDenumire(), tratament.getPret());
        String tip = (decontare == null) ? "-" : decontare.getTipDecontare();
        text += String.format("   Total: %.2f lei | %s acopera: %.2f lei | PACIENTUL PLATESTE: %.2f lei",
                getValoareTotala(), tip, getSumaAcoperita(), getSumaDePlata());
        return text;
    }
}
