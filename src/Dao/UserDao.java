package Dao;
import java.util.List;
import Models.User;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUser(String username);
    public boolean createUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public boolean authUser(User user);
}
