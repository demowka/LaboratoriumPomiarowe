package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kalibracja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    private LocalDate dataKalibracji;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private UrzadzeniePomiarowe urzadzeniePomiarowe;

    private String wynikKalibracji;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Metrolog metrolog;

    @CreationTimestamp
    private  LocalDate terminWaznosci;



}
