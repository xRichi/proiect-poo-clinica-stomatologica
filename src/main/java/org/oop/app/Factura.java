package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public class Factura {
    @EqualsAndHashCode.Include
    @NonNull private String serie;
    @EqualsAndHashCode.Include
    @NonNull private Integer numar;
    @NonNull private Programare programare;
    private boolean achitata = false;

    public Double getTotal() {
        return programare.getValoareTotala();
    }

    public Double getSumaDecontata() {
        return programare.getSumaAcoperita();
    }

    public Double getSumaPacient() {
        return programare.getSumaDePlata();
    }

    public void achita() {
        achitata = true;
    }

    public String getDetalii() {
        return String.format("Factura %s %d - pacient: %s | total: %.2f lei | decontat: %.2f lei | de plata pacient: %.2f lei | %s | scutit TVA",
                serie, numar, programare.getPacient().getNume(),
                getTotal(), getSumaDecontata(), getSumaPacient(), achitata ? "achitata" : "neachitata");
    }
}
