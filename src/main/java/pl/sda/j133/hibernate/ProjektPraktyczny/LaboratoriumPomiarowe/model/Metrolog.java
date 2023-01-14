package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Metrolog {

    private String imie;
    private String nazwisko;

    @OneToMany(mappedBy = "metrolog")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Kalibracja> kalibracje;

}
