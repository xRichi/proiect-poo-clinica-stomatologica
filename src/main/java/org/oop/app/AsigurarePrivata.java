package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@NoArgsConstructor
public class AsigurarePrivata extends Decontare {
    private String asigurator;
    private Double procentAcoperit = 0.0;

    public AsigurarePrivata(Integer idDecontare, String asigurator, Double procentAcoperit) {
        super(idDecontare);
        this.asigurator = asigurator;
        this.procentAcoperit = procentAcoperit;
    }

    @Override
    public Double getSumaDePlataPacient(Double valoareTotala) {
        return valoareTotala * (100 - procentAcoperit) / 100;
    }

    @Override
    public String getTipDecontare() {
        return "Asigurare privata " + asigurator;
    }
}
