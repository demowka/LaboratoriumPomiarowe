package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda;

import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.DataBase.DataAccessObject;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.Metrolog;

public class KomendaListaMetrolog implements Komenda {
    private DataAccessObject<Metrolog> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista metrolog";
    }

    @Override
    public void obsluga() {
        dao.findAll(Metrolog.class).forEach(System.out::println);
    }
}

