package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@NoArgsConstructor
public class DecontareCAS extends Decontare {
    private Double plafonDecontat = 0.0;

    public DecontareCAS(Integer idDecontare, Double plafonDecontat) {
        super(idDecontare);
        this.plafonDecontat = plafonDecontat;
    }

    @Override
    public Double getSumaDePlataPacient(Double valoareTotala) {
        if (valoareTotala <= plafonDecontat)
            return 0.0;
        return valoareTotala - plafonDecontat;
    }

    @Override
    public String getTipDecontare() {
        return "Decontare CAS";
    }
}
