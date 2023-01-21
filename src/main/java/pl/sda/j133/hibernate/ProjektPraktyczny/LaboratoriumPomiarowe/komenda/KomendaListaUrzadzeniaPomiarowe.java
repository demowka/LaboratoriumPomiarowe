package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda;

import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.DataBase.DataAccessObject;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.UrzadzeniePomiarowe;

public class KomendaListaUrzadzeniaPomiarowe implements Komenda {
    private DataAccessObject<UrzadzeniePomiarowe> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista urzadzen pomiarowych";
    }

    @Override
    public void obsluga() {
        dao.findAll(UrzadzeniePomiarowe.class).forEach(System.out::println);
    }
}

