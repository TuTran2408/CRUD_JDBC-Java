package backend.businesslayer;


import backend.datalayer.UserRepository;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }
    public boolean registerE(String fullname,String email,String password,int expInYear,String proSkill,String projectId)
            throws ClassNotFoundException, SQLException {
        return userRepository.registerE(fullname,email,password,expInYear,proSkill,projectId);
    }
    public List<User> getListUserById(String projectId) throws ClassNotFoundException, SQLException {
        return userRepository.getListUserById(projectId);
    }

    public List<User> getListUser() throws ClassNotFoundException, SQLException {
        return userRepository.getListUser();
    }

    public User login(String email, String password) throws SQLException, ClassNotFoundException {
        return userRepository.login(email,password);
    }
    public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return userRepository.isUserExistsByEmail(email);
    }
}
