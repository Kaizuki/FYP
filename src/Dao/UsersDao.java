package Dao;
import java.util.List;
import Models.Users;

public interface UsersDao {
    public List<Users> getAllUsers();
    public Users getUser(String username);
    public boolean createUser(Users user);
    public void updateUser(Users user);
    public void deleteUser(Users user);
    public boolean authUser(Users user);
}
