package project.sales.app.commands;

import project.sales.app.database.DataAccessObject;
import project.sales.app.model.Customer;
import project.sales.app.model.Order;
import project.sales.app.model.Product;

import java.util.Optional;

public class AddOrderItem implements Command {

    private DataAccessObject<Order> dao = new DataAccessObject<Order>();
    private DataAccessObject<Customer> daoCustomer = new DataAccessObject<Customer>();
    private DataAccessObject<Product> daoProduct = new DataAccessObject<Product>();

    private boolean shouldExecuteFollowupCommand = false;
    private Long orderId;

    public AddOrderItem(Long orderId) {
        this.orderId = orderId;
    }

    public AddOrderItem() {
    }

    @Override
    public String getKomenda() {
        return "Nowa pozycja";
    }

    @Override
    public void obsluga() {
        if (orderId == null) {
            System.out.println("Podaj id zamówienia, dla ktorego chcesz dodać item");
            String idStringOrder = Command.scanner.nextLine();
            orderId = Long.parseLong(idStringOrder);
        }
        Optional<Order> orderOpt = dao.find(Order.class, orderId);
        if (orderOpt.isEmpty()) {
            System.err.println("Podany order nie istnieje");
            return;
        }
    }

    @Override
    public Optional<Command> getFollowUpCommand() {
        return Optional.empty();
    }
}
