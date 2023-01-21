package project.sales.app;

import project.sales.app.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainCompany {
    public static void main(String[] args) {

        List<Command> listaKomend = new ArrayList<>(
                List.of(
                        new AddProduct(),
                        new AddDelivery(),
                        new AddCustomer(),
                        new AddOrder(),
                        new AddOrderItem(),
                        new ProductList()
                )
        );
        String komenda;
        do {
            System.out.println("Lista dostepnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {


                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            System.out.println("Podaj komende:");
            komenda = Command.scanner.nextLine();

            for (Command dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();

                    Optional<Command> followUpCommand = dostepnaKomenda.getFollowUpCommand();
                    if (followUpCommand.isPresent()){
                        followUpCommand.get().obsluga();
                    }
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}
