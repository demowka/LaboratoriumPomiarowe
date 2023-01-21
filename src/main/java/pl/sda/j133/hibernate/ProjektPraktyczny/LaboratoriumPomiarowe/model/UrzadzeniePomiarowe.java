package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrzadzeniePomiarowe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nazwa;
    private String numerSeryjny;
    private String producent;
    private String zakresPomiarowy;
    private String dokladnoscPomiarowa;
    private String lokalizacjaUrzadzenia;

    @OneToMany(mappedBy = "urzadzeniePomiarowe")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Kalibracja> kalibracje;

}
