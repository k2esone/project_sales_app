package project.sales.app.commands;

import project.sales.app.database.DataAccessObject;
import project.sales.app.model.Delivery;
import project.sales.app.model.Product;

import java.util.Optional;

public class AddDelivery implements Command{

    private DataAccessObject<Delivery> dao = new DataAccessObject<Delivery>();
    private DataAccessObject<Product> daoProduct = new DataAccessObject<Product>();
    @Override
    public String getKomenda() {
        return "Dodaj nowa dostawe";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id produktu, do ktorego chcesz odpisac nowa dostawe");
        String idString = Command.scanner.nextLine();
        Long idProduct = Long.parseLong(idString);
        Optional<Product> productOptional = daoProduct.find(Product.class, idProduct);
        if (productOptional.isEmpty()) {
            System.err.println("Podany produkt nie istnieje");
            return;
        }

        System.out.println("Podaj ilosc");
        String quantityString = Command.scanner.nextLine();
        int quantity = Integer.parseInt(quantityString);

        System.out.println("Podaj cene zakupu produktu");
        String buyPriceString = Command.scanner.nextLine();
        double buyPrice = Double.parseDouble(buyPriceString);


        Delivery delivery = Delivery.builder()
                .quantity(quantity)
                .price(buyPrice)
                .product(productOptional.get())
                .build();

        dao.insert(delivery);


    }
}
