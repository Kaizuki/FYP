import Blockchain.BlockchainOperation.BlockType;
import Blockchain.OrderOperation;
import Controller.UserController;
import Models.Inventory;
import Models.Orders;
import Models.Stocks;

public class App {
    public static void main(String[] args) throws Exception {

        UserController userController = new UserController();
        // userController.getUserData("peach");
        // User user = new User("peach", "peach", "peach@gmail.com", "manager");
        // userController.authUser(user);
        // userController.createNewUser(user);

        Orders order1 = new Orders(1, 88, 12, 13);
        Orders order2 = new Orders(4, 12, 99, 23);
        Orders order3 = new Orders(3, 31, 32, 33);

        Inventory inventory1 = new Inventory(12, "Mouse");
        Inventory inventory2 = new Inventory(13, "Keyboard");
        Inventory inventory3 = new Inventory(15, "Headphones");

        Stocks stock1 = new Stocks(22, 12, 3);
        Stocks stock2 = new Stocks(25, 12, 32);
        Stocks stock3 = new Stocks(26, 13, 34);

        OrderOperation bc1 = new OrderOperation(BlockType.ORDER);
        bc1.createBlock(order1);
        bc1.createBlock(order2);

        System.out.println("BC1: " + bc1.toString());

        System.out.println("\nReading Orders Lists:\n" + bc1.getOrders().toString());

        InventoryOperation bc2 = new InventoryOperation(BlockType.INVENTORY);
        bc2.createBlock(inventory1);
        bc2.createBlock(inventory3);

        System.out.println("\nReading Inventory Lists:\n" + bc2.getInventory().toString());

        StocksOperation bc3 = new StocksOperation(BlockType.STOCK);
        bc3.createBlock(stock2);
        bc3.createBlock(stock1);

        System.out.println("\nReading Stocks Lists:\n" + bc3.getStocks().get(0).getStockId());
    }
}
