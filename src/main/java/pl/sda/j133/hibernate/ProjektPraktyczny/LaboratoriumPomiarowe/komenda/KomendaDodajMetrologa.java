package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda;

import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.DataBase.DataAccessObject;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.Metrolog;

public class KomendaDodajMetrologa implements Komenda {
    private DataAccessObject<Metrolog> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj metrologa";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imię metrologa:");
        String imie = Komenda.SCANNER.nextLine();

        System.out.println("Podaj nazwisko metrologa:");
        String nazwisko = Komenda.SCANNER.nextLine();

        Metrolog metrolog = Metrolog.builder()
                .imie(imie)
                .nazwisko(nazwisko)
                .build();

        dao.insert(metrolog);
    }
}
