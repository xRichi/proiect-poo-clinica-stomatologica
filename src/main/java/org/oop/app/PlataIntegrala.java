package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@NoArgsConstructor
public class PlataIntegrala extends Decontare {

    public PlataIntegrala(Integer idDecontare) {
        super(idDecontare);
    }

    @Override
    public Double getSumaDePlataPacient(Double valoareTotala) {
        return valoareTotala;
    }

    @Override
    public String getTipDecontare() {
        return "Plata integrala";
    }
}
