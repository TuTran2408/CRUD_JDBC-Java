package backend.datalayer;

import entity.Employee;
import entity.Manager;
import entity.Role;
import entity.User;
import ultis.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private JDBCUtils jdbcUtils;

    public UserRepository() {
        jdbcUtils = new JDBCUtils();
    }
    public boolean registerE(String fullname,String email,String password,int expInYear,String proSkill,String projectId)
            throws ClassNotFoundException, SQLException{
        try {
            Connection connection = jdbcUtils.getConnection();
            String sql = "INSERT INTO `user`(fullname,email,`password`,expInYear,proSkill,projectId,`role`)\n" +
                    "values(?,?,?,?,?,?,'Employee')";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fullname);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setInt(4, expInYear);
            statement.setString(5, proSkill);
            statement.setString(6, projectId);

            int c = statement.executeUpdate();
            if (c > 0) {
                return true;
            } else {
                return false;
            }
        }
        finally {
            jdbcUtils.disconnect();
        }
    }
    public List<User> getListUserById(String projectId) throws ClassNotFoundException, SQLException {

        List<User> users = new ArrayList<>();
        Connection connection = jdbcUtils.getConnection();

        String sql = "select id,fullName,email,password,`role` from `user` where projectId = ? and `role` = 'Employee'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, projectId);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String fullName = resultSet.getString(2);
            String email = resultSet.getString(3);
            String password = resultSet.getString(4);
            String role = resultSet.getString(5);
            Role rol = role.equals("Employee") ? Role.Employee : Role.Manager;
            users.add(new User(id, fullName, email, password, rol));
        }
            jdbcUtils.disconnect();
            return users;
    }


    public List<User> getListUser() throws ClassNotFoundException, SQLException {
            Connection connection = jdbcUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select id,fullName,email,password,`role` from `user` where `role` = 'Manager'";

            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fullName = resultSet.getString(2);
                String email = resultSet.getString(3);
                String password = resultSet.getString(4);
                String role = resultSet.getString(5);
                Role rol = role.equals("Manager") ? Role.Manager : Role.Employee;
                users.add(new User(id, fullName, email, password, rol));
            }
            jdbcUtils.disconnect();
            return users;
    }



    public User login(String email, String password) throws SQLException, ClassNotFoundException {
        try {
            // Step 1: get connection
            Connection connection = jdbcUtils.getConnection();

            // Step 2: Create a statement obiect
            String sql = "select * from `user` where email = ? and `password` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            // Step 3: Execute SQL query
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handling Result Set
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fullName = resultSet.getString(2);

                String role = resultSet.getString(8);
                Role rol = role.equals("Manager") ? Role.Manager : Role.Employee;

                if (role.equals("Manager")) {
                    int expInYear = resultSet.getInt(5);
                    String projectId = resultSet.getString(7);


                    User manager = new Manager(id, fullName, email, password, rol,
                            projectId, expInYear);
                    return manager;
                } else {
                    String proSkill = resultSet.getString(6);
                    String projectId = resultSet.getString(7);

                    User employee = new Employee(id, fullName, email, password, rol,
                            projectId, proSkill);
                    return employee;
                }
            } else {
                return null;
            }
        } finally {
            jdbcUtils.disconnect();
        }

    }
    public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
        try {
            // Step 1: get connection
            Connection connection = jdbcUtils.getConnection();

            // Step 2: Create a statement obiect
            String sql = "SELECT 1 FROM `user` WHERE email = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            // Step 3: Execute SQL query
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handling Result Set
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } finally {
            jdbcUtils.disconnect();
        }
    }


}
