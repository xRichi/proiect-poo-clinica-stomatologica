package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public abstract class Decontare {
    @EqualsAndHashCode.Include
    @NonNull protected Integer idDecontare;

    public abstract Double getSumaDePlataPacient(Double valoareTotala);

    public abstract String getTipDecontare();

    public Double getSumaAcoperita(Double valoareTotala) {
        return valoareTotala - getSumaDePlataPacient(valoareTotala);
    }
}
