package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public class Specializare {
    @EqualsAndHashCode.Include
    @NonNull private Integer idSpecializare;
    @NonNull private String denumire;
    @NonNull private Double tarifConsultatie;
}
