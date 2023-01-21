package project.sales.app.commands;

import project.sales.app.database.DataAccessObject;
import project.sales.app.model.Customer;
import project.sales.app.model.Delivery;
import project.sales.app.model.Order;
import project.sales.app.model.Product;

import java.util.Optional;

public class AddOrder implements Command {

    private DataAccessObject<Order> dao = new DataAccessObject<Order>();
    private DataAccessObject<Customer> daoCustomer = new DataAccessObject<Customer>();
    private DataAccessObject<Product> daoProduct = new DataAccessObject<Product>();

    private boolean shouldExecuteFollowupCommand = false;
    private Order createdOrder = null;

    @Override
    public String getKomenda() {
        return "Nowe zamowienie";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id klienta, dla ktorego chcesz zrobic zamowienie");
        String idStringCustomer = Command.scanner.nextLine();
        Long idCustomer = Long.parseLong(idStringCustomer);
        Optional<Customer> customerOptional = daoCustomer.find(Customer.class, idCustomer);
        if (customerOptional.isEmpty()) {
            System.err.println("Podany klient nie istnieje");
            return;
        }
//
//        System.out.println("Podaj id produktu, ktory chcesz dodac do zamowienia");
//        String idStringProduct = Command.scanner.nextLine();
//        Long idProduct = Long.parseLong(idStringProduct);
//        Optional<Product> productOptional = daoProduct.find(Product.class, idProduct);
//        if (productOptional.isEmpty()) {
//            System.err.println("Podany produkt nie istnieje");
//            return;
//        }

        Order order = Order.builder()
                .orderItems(null)
                .customer(customerOptional.get())
                .build();

        dao.insert(order);
        createdOrder = order;

        System.out.println("Czy chcesz dodać pozycje do zamówienia:");
        String answer = Command.scanner.nextLine();
        if (answer.equals("true")) {
            shouldExecuteFollowupCommand = true;
        }
    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        if (shouldExecuteFollowupCommand) {
            return Optional.of(new AddOrderItem(createdOrder.getId()));
        }
        return Optional.empty();
    }
}
