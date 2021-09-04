package Controller;

import Dao.UsersDao;
import Dao.UsersDaoImpl;
import Models.Users;

public class UsersController {
    UsersDao manageUser = new UsersDaoImpl();

    //! TODO: Remeber to convert all the return methods accordingly
    
    public void getUserData(String username) {
        Users user  = manageUser.getUser(username);
        if (user != null)  
            System.out.println(user.toString());
        else
            System.out.println("User " + username + " not found");
    }

    public void getAllUserData() {
        for (Users user : manageUser.getAllUsers()) {
            System.out.println(user.toString());
        }
    }

    public void authUser(Users user) {
        boolean authResult = manageUser.authUser(user);
        if (authResult)
            System.out.println("Correct Credential");
        else
            System.out.println("Incorrect Credential");
    }

    public void createNewUser(Users user) {
        boolean insertResult = manageUser.createUser(user);
        if (insertResult)
            System.out.println("Inserted successfully!");
        else
            System.out.println("Inserted failed");
    }

}
