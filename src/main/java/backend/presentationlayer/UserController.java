package backend.presentationlayer;

import backend.businesslayer.UserService;
import backend.datalayer.UserRepository;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserService();
    }
    public boolean registerE(String fullname,String email,String password,int expInYear,String proSkill,String projectId)
            throws ClassNotFoundException, SQLException {
        return userService.registerE(fullname,email,password,expInYear,proSkill,projectId);
    }
    public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return userService.isUserExistsByEmail(email);
    }
    public List<User> getListUserById(String projectId) throws ClassNotFoundException, SQLException {
        return userService.getListUserById(projectId);
    }


    public List<User> getListUser() throws ClassNotFoundException, SQLException {
        return userService.getListUser();
    }


    public User login(String email, String password) throws SQLException, ClassNotFoundException {
        return userService.login(email,password);
    }

}
