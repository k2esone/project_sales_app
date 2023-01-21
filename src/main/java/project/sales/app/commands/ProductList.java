package project.sales.app.commands;

import project.sales.app.database.DataAccessObject;
import project.sales.app.model.Product;

import java.util.List;

public class ProductList implements Command {

    DataAccessObject<Product> dao = new DataAccessObject<Product>();

    @Override
    public String getKomenda() {
        return "Lista produktow";
    }

    @Override
    public void obsluga() {
        List<Product> products = dao.findAll(Product.class);
        products.forEach(System.out::println);
    }
}
