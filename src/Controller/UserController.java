package Controller;

import java.util.List;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Models.User;

public class UserController {
    UserDao userDao = new UserDaoImpl();
    UserDaoImpl userDaoImpl = new UserDaoImpl();
    
    public User getUserDataWithID(String userId) {
        User user  = userDao.getUserWithID(userId);
        if (userId == null) {
        	return null;
        } else {
        	if (user != null)  
                return user;
            else
                return null;
        }
    }

    public User getUserData(String userName) {
        User user  = userDao.getUser(userName);
        if (userName == null) {
        	return null;
        } else {
        	if (user != null)  
                return user;
            else
                return null;
        }
    }

    public List<User> getAllUserData() {
    	return userDao.getAllUsers();
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

    public boolean createNewUser(String userName, String userPass, String userEmail, String userRole) {
        boolean insertResult = userDao.createUser(new User(userName, userPass, userEmail, userRole));
        if (insertResult) {
            System.out.println("Inserted successfully!");
            return true;
        }
        else {
            System.out.println("Inserted failed");
            return false;
        }
    }

    public void deleteUser(String userName) {
        boolean deleteResult = userDao.deleteUser(userName);
        if (deleteResult)
            System.out.println("User: " + userName + " deleted successfully!");
        else
            System.out.println("User: " + userName + " Failed to delete!");
    }

    public boolean chkDuplicateUser(String userName) {
    	return userDaoImpl.chkDuplicateUser(userName);
    }

}
