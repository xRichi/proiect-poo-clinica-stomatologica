package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public class Medic {
    @EqualsAndHashCode.Include
    @NonNull private Integer idMedic;
    @NonNull private String nume;
    @NonNull private Specializare specializare;
}
