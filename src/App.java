import java.util.LinkedList;

import Blockchain.Block;
import Blockchain.Blockchain;
import Blockchain.BlockchainOperation;
import Controller.UserController;
import Models.Orders;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Dbconnect dbconn = new Dbconnect();

        // String sql = "SELECT * FROM users";
        // try {
        // PreparedStatement statement = dbconn.connect().prepareStatement(sql);
        // ResultSet aa = statement.executeQuery();
        // System.out.println("SQL Query: " + aa);

        // while (aa.next()) {
        // System.out.println(aa.getInt(1));
        // System.out.println(aa.getString("user_name"));
        // // System.out.println(aa.getString(3));
        // }
        // } catch (SQLException e) {
        // e.printStackTrace();
        // } finally {
        // dbconn.disconnect();
        // }

        UserController userController = new UserController();
        // userController.getUserData("peach");
        // User user = new User("peach", "peach", "peach@gmail.com", "manager");
        // userController.authUser(user);
        // userController.createNewUser(user);

        Orders order1 = new Orders(1, 11, 12, 13);
        Orders order2 = new Orders(2, 21, 22, 23);
        Orders order3 = new Orders(3, 31, 32, 33);

        Blockchain blockchain = new Blockchain();
        // BlockchainOperation.initBlock(order3);
        // BlockchainOperation.nextBlock(order2);
        // BlockchainOperation.nextBlock(order1);
        // BlockchainOperation.nextBlock(order3);
    }
}
