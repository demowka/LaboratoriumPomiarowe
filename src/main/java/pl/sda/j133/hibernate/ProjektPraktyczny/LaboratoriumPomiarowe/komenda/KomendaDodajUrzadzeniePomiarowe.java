package pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.komenda;

import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.DataBase.DataAccessObject;
import pl.sda.j133.hibernate.ProjektPraktyczny.LaboratoriumPomiarowe.model.UrzadzeniePomiarowe;

public class KomendaDodajUrzadzeniePomiarowe implements Komenda {
    private DataAccessObject<UrzadzeniePomiarowe> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj urzadzenie pomiarowe";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwę urządzenia:");
        String nazwa = Komenda.SCANNER.nextLine();

        System.out.println("Podaj numer seryjny:");
        String numerSeryjny = Komenda.SCANNER.nextLine();

        System.out.println("Podaj producenta urządzenia:");
        String producent = Komenda.SCANNER.nextLine();

        System.out.println("Podaj zakres pomiarowy:");
        String zakresPomiarowyString = Komenda.SCANNER.nextLine();
        int zakresPomiarowy = Integer.parseInt(zakresPomiarowyString);

        System.out.println("Podaj dokładność pomiarową:");
        String dokladnoscPomiarowaString = Komenda.SCANNER.nextLine();
        int dokladnoscPomiarowa = Integer.parseInt(dokladnoscPomiarowaString);

        System.out.println("Jaka jest lokalizacja urządzenia:");
        String lokalizacjaUrzadzenia = Komenda.SCANNER.nextLine();

        UrzadzeniePomiarowe urzadzeniePomiarowe = UrzadzeniePomiarowe.builder()
                .nazwa(nazwa)
                .numerSeryjny(numerSeryjny)
                .producent(producent)
                .zakresPomiarowy(zakresPomiarowy)
                .dokladnoscPomiarowa(dokladnoscPomiarowa)
                .lokalizacjaUrzadzenia(lokalizacjaUrzadzenia)
                .build();

        dao.insert(urzadzeniePomiarowe);
    }
}
