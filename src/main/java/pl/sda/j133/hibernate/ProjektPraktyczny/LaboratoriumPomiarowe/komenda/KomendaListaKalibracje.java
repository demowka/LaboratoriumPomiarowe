package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda;

import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.DataBase.DataAccessObject;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.Kalibracja;

public class KomendaListaKalibracje implements Komenda {
    private DataAccessObject<Kalibracja> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista kalibracja";
    }

    @Override
    public void obsluga() {
        dao.findAll(Kalibracja.class).forEach(System.out::println);
    }
}