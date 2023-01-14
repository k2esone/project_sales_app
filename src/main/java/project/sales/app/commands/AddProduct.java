package project.sales.app.commands;

import project.sales.app.database.DataAccessObject;
import project.sales.app.model.Delivery;
import project.sales.app.model.Product;

public class AddProduct implements Command {

    private DataAccessObject<Product> dao = new DataAccessObject<Product>();

    @Override
    public String getKomenda() {
        return "Dodaj nowy produkt";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe produktu");
        String name = Command.scanner.nextLine();

        System.out.println("Podaj marke produktu");
        String brand = Command.scanner.nextLine();

        System.out.println("Podaj specyfikacje produktu (marke auta do ktorej przypisany jest produkt");
        String use = Command.scanner.nextLine();

        Product product = Product.builder()
                .name(name)
                .brand(brand)
                .use(use)
                .build();

        dao.insert(product);
    }
}
