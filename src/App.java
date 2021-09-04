import Controller.UsersController;
import Models.Users;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Dbconnect dbconn = new Dbconnect();
        
        // String sql =  "SELECT * FROM users";
        // try {
        //     PreparedStatement statement = dbconn.connect().prepareStatement(sql);
        //     ResultSet aa = statement.executeQuery();
        //     System.out.println("SQL Query: " + aa);

        //     while (aa.next()) {
        //         System.out.println(aa.getInt(1));
        //         System.out.println(aa.getString("user_name"));
        //         // System.out.println(aa.getString(3));
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // } finally {
        //     dbconn.disconnect();
        // }

       UsersController manageUser = new UsersController();
       manageUser.getUserData("asd");
       Users newuser = new Users("hey2", "eli1234", "manager");
       manageUser.createNewUser(newuser);
       
    }
}
