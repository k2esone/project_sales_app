package project.sales.app.commands;

import project.sales.app.database.DataAccessObject;
import project.sales.app.model.Customer;
import project.sales.app.model.Order;
import project.sales.app.model.Product;
import project.sales.app.model.Return;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReturnProduct implements Command{

    DataAccessObject<Order> daoOrder = new DataAccessObject<Order>();
    DataAccessObject<Return> daoReturn = new DataAccessObject<Return>();
    DataAccessObject<Product> daoProduct = new DataAccessObject<Product>();
    @Override
    public String getKomenda() {
        return "Zwroc produkt";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id zamowienia, do ktorego chcesz zrobic zwrot");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        Optional<Order> orderOptional = daoOrder.find(Order.class, id);
        if (orderOptional.isEmpty()) {
            System.err.println("Zamowienie o podanym id nie istnieje");
            return;
        }

        String idProduct = "";
        List<Product> productList = new ArrayList<>();

        do {

            System.out.println("Podaj id produktu, ktory chcesz zwrocic");
            idProduct = Command.scanner.nextLine();
            Long idProd = Long.parseLong(idProduct);

            Optional<Product> productOptional = daoProduct.find(Product.class, id);
            if (productOptional.isEmpty()) {
                System.err.println("Produkt o podanym id nie istnieje");
                return;
            }


        } while (!idProduct.equalsIgnoreCase("exit"));

    }
}
