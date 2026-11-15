package org.oop.app;

import lombok.*;

@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor @RequiredArgsConstructor
public class Pacient {
    @EqualsAndHashCode.Include
    @NonNull private Integer idPacient;
    @NonNull private String nume;
    @NonNull private String telefon;
    @NonNull private Integer varsta;
    private String email;
}
