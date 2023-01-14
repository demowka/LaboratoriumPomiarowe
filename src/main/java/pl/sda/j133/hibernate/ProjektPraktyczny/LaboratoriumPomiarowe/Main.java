package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe;

import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda.Komenda;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda.KomendaDodajKalibracje;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda.KomendaDodajMetrologa;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda.KomendaDodajUrzadzeniePomiarowe;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    List<Komenda> listaKomend = List.of(
            new KomendaDodajUrzadzeniePomiarowe(),
            new KomendaDodajMetrologa(),
            new KomendaDodajKalibracje()

    );

    String komenda;
        do {
        System.out.println("Lista dostępnych komend:");
        for (int i = 0; i < listaKomend.size(); i++) {
            // wiersz po wierszu wypiszą się komendy w formie:
            // 1. dodaj X
            // 2. dodaj y ...
            System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
        }
        System.out.println(); // pusta nowa linia która oddziela poprzednią listę

        System.out.println("Podaj komende:");
        komenda = Komenda.SCANNER.nextLine();

        for (Komenda dostepnaKomenda : listaKomend) {
            if (dostepnaKomenda.getKomenda().equals(komenda)) {
                dostepnaKomenda.obsluga();
            }
        }
    } while (!komenda.equalsIgnoreCase("exit"));
}
}
