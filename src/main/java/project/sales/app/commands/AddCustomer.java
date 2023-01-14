package project.sales.app.commands;

import project.sales.app.database.DataAccessObject;
import project.sales.app.model.Customer;
import project.sales.app.model.Delivery;
import project.sales.app.model.Product;

public class AddCustomer implements Command{

    private DataAccessObject<Customer> dao = new DataAccessObject<Customer>();
    @Override
    public String getKomenda() {
        return "Dodaj nowego klienta do bazy";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj imie klienta");
        String name = Command.scanner.nextLine();

        System.out.println("Podaj adres klienta");
        String address = Command.scanner.nextLine();

        System.out.println("Podaj NIP klienta");
        String nip = Command.scanner.nextLine();

        Customer customer = Customer.builder()
                .name(name)
                .address(address)
                .nip(nip)
                .build();

        dao.insert(customer);

    }
}
