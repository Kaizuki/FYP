import Blockchain.BlockchainOperation;
import Blockchain.BlockchainOperation.BlockType;
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
        
        BlockchainOperation bc1 = new BlockchainOperation(BlockType.ORDER);
        bc1.createBlock(order1);
        bc1.createBlock(order2);

        System.out.println("BC1: " + bc1.toString());
        
        BlockchainOperation bc2 = new BlockchainOperation(BlockType.INVENTORY);
        bc2.createBlock(order3);
        bc2.createBlock(order2);
        
        BlockchainOperation bc3 = new BlockchainOperation(BlockType.STOCK);
        bc3.createBlock(order3);


    }
}
