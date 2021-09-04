package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Models.Users;
import db_connection.Dbconnect;

public class UsersDaoImpl implements UsersDao{

    Dbconnect dbconnect;

    Logger logger = Logger.getLogger(UsersDaoImpl.class.getName());

    public UsersDaoImpl() {
        dbconnect = new Dbconnect();
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> fetchUsers = new ArrayList<Users>();
        String sqlQuery = "SELECT * FROM users";
        try {
            PreparedStatement st = dbconnect.connect().prepareStatement(sqlQuery);
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Fetching [users] lists from DB.");
            
            //Extracting data from resultset and mapping onto Users object
            while (rs.next()) {
                Users user = new Users(
                    rs.getInt(1), //user_id
                    rs.getString(2), //user_name
                    rs.getString(3), //user_pass
                    rs.getString(4) //user_role
                );
                fetchUsers.add(user);
            }
            return fetchUsers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbconnect.disconnect();
        }        
    }

    @Override
    public Users getUser(String username) {
        String sqlQuery = "SELECT * FROM users WHERE user_name = ?";
        try {
            Users user = null;
            PreparedStatement st = dbconnect.connect().prepareStatement(sqlQuery);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Fetching [users] " + username + " from DB.");

            //Extracting data from resultset and mapping onto Users object
            while (rs.next()) {
                user = new Users(
                    rs.getInt(1), //user_id
                    rs.getString(2), //user_name
                    rs.getString(3), //user_pass
                    rs.getString(4) //user_role
                ); 
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbconnect.disconnect();
        }
    }

    @Override
    public boolean createUser(Users user) {
        String sqlQuery = "INSERT INTO users (user_name, user_pass, user_role) "
        + "VALUES (?, ?)";
        try {
            boolean duplicateResult = chkDuplicateUser(user.getUserName());
            if (!duplicateResult) {
                resetIdCount();
                PreparedStatement st = dbconnect.connect().prepareStatement(sqlQuery);
                st.setString(1, user.getUserName());
                st.setString(2, user.getUserPass());
                int row = st.executeUpdate(); //Executeupdate would return the number of rows successfully inserted
                logger.log(Level.INFO, "Insert [users] new user " + user.getUserName() + " to DB.");
    
                System.out.println("Affected rows: " + row);  
                if (row > 0)
                    return true;
                else
                    return false;
            } else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            dbconnect.disconnect();
        }
    }

    @Override
    public void updateUser(Users user) {
        
    }

    @Override
    public void deleteUser(Users user) {
        
    }

    @Override
    public boolean authUser(Users user) {
        //* UPGRADE: Add hashing and encryption to param before comparing db result
        String sqlQuery = "SELECT * FROM users WHERE user_name = ? AND user_pass = ?";
        try {
            PreparedStatement st = dbconnect.connect().prepareStatement(sqlQuery);
            st.setString(1, user.getUserName());
            st.setString(2, user.getUserPass());
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Authenticating [users] " + user.getUserName() + " credential.");

            if (rs.next())
                return true;
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            dbconnect.disconnect();
        }
    }

    //Reset auto_increment counter for user_id
    private void resetIdCount() {
        String sqlQuery = "ALTER TABLE users AUTO_INCREMENT = 1";
        try {
            PreparedStatement st = dbconnect.connect().prepareStatement(sqlQuery);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbconnect.disconnect();
        }
    }

    private boolean chkDuplicateUser(String username) {
        String sqlQuery = "SELECT * FROM users WHERE user_name = ?";
        try {
            PreparedStatement st = dbconnect.connect().prepareStatement(sqlQuery);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            logger.log(Level.INFO, "Auth Duplicate User " + username + ".");

            if (rs.next()) {
                System.out.println("Duplicated user found");
                return true;
            }
            else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        } finally {
            dbconnect.disconnect();
        }
    }
    
}
