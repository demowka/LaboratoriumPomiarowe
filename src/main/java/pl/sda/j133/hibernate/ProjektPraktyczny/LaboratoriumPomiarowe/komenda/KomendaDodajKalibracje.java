package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda;

import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.DataBase.DataAccessObject;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.Kalibracja;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.Metrolog;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.UrzadzeniePomiarowe;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.WynikKalibracji;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class KomendaDodajKalibracje implements Komenda {
    private DataAccessObject<Kalibracja> dao = new DataAccessObject<>();
    private DataAccessObject<UrzadzeniePomiarowe> daoUrzadzeniePomiarowe = new DataAccessObject<>();
    private DataAccessObject<Metrolog> daoMetrolog = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj kalibracje";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id urządzenia pomiarowego:");
        String idUrzadzeniePomiaroweString = Komenda.SCANNER.nextLine();
        Long idUrzadzeniePomiarowe = Long.parseLong(idUrzadzeniePomiaroweString);
        Optional<UrzadzeniePomiarowe> urzadzeniePomiaroweOptional = daoUrzadzeniePomiarowe.find(UrzadzeniePomiarowe.class, idUrzadzeniePomiarowe);
        if (urzadzeniePomiaroweOptional.isEmpty()) {
            System.err.println("Urządzenie o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj id metrologa:");
        String idMetrologString = Komenda.SCANNER.nextLine();
        Long idMetrolog = Long.parseLong(idMetrologString);
        Optional<Metrolog> metrologOptional = daoMetrolog.find(Metrolog.class, idMetrolog);
        if (metrologOptional.isEmpty()) {
            System.err.println("Metrolog o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj datę wykonania kalibracji:");
        String dataKalibracjiString = Komenda.SCANNER.nextLine();
        LocalDate dataKalibracji = LocalDate.parse(dataKalibracjiString);

        System.out.println("Podaj urządzenie pomiarowe:");
        String urzadzeniePomiarowe = Komenda.SCANNER.nextLine();

        System.out.println("Wybierz wynik kalibracji:");
        String wynikKalibracjiWybierz = Komenda.SCANNER.nextLine();
        WynikKalibracji wynikKalibracji = WynikKalibracji.valueOf(wynikKalibracjiWybierz);

        System.out.println("Podaj metrologa wykonującego kalibracje:");
        String metrolog = Komenda.SCANNER.nextLine();

        System.out.println("Podaj termin ważności:");
        String terminWaznosciString = Komenda.SCANNER.nextLine();
        LocalDate terminWaznosci = LocalDate.parse(terminWaznosciString);

        Kalibracja kalibracja = Kalibracja.builder()
                .metrolog(metrologOptional.get())
                .urzadzeniePomiarowe(urzadzeniePomiaroweOptional.get())
                .dataKalibracji(dataKalibracji)
                .wynikKalibracji(wynikKalibracji)
                .terminWaznosci(terminWaznosci)
                .build();

        dao.insert(kalibracja);
    }
}
