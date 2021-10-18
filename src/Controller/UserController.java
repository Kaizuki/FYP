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
    public User authUser(User user) {
        boolean authResult = userDao.authUser(user);
        if (authResult) {
            User authUser = userDao.getUser(user.getUserName());
        	System.out.println("Correct Credential");
        	return authUser;
        }
        else {
        	System.out.println("Incorrect Credential");
        	return null;
        }
    }

    public void createNewUser(String userName, String userPass, String userEmail, String userRole) {
        boolean insertResult = userDao.createUser(new User(userName, userPass, userEmail, userRole));
        if (insertResult)
            System.out.println("Inserted successfully!");
        else
            System.out.println("Inserted failed");
    }

    public void deleteUser(String userName) {
        boolean deleteResult = userDao.deleteUser(userName);
        if (deleteResult)
            System.out.println("User: " + userName + " deleted successfully!");
        else
            System.out.println("User: " + userName + " Failed to delete!");
    }

}
