package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public class Tratament {
    @EqualsAndHashCode.Include
    @NonNull private Integer idTratament;
    @NonNull private String denumire;
    @NonNull private Double pret;
    @NonNull private Specializare specializare;
}
