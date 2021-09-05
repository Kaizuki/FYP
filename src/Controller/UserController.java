package Controller;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Models.User;

public class UserController {
    UserDao userDao = new UserDaoImpl();

    //! TODO: Remeber to convert all the return methods accordingly
    
    public void getUserData(String username) {
        User user  = userDao.getUser(username);
        if (user != null)  
            System.out.println(user.toString());
        else
            System.out.println("User " + username + " not found");
    }

    public void getAllUserData() {
        for (User user : userDao.getAllUsers()) {
            System.out.println(user.toString());
        }
    }

    public void authUser(User user) {
        boolean authResult = userDao.authUser(user);
        if (authResult)
            System.out.println("Correct Credential");
        else
            System.out.println("Incorrect Credential");
    }

    public void createNewUser(User user) {
        boolean insertResult = userDao.createUser(user);
        if (insertResult)
            System.out.println("Inserted successfully!");
        else
            System.out.println("Inserted failed");
    }

}
