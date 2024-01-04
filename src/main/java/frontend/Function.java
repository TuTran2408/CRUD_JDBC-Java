package frontend;

import backend.presentationlayer.UserController;
import entity.User;
import ultis.ScannerUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Function {
    private UserController userController;

    public Function() {
        userController = new UserController();
    }
    Scanner scanner = new Scanner(System.in);
    public void getListUserById() throws ClassNotFoundException, SQLException {
        System.out.println("Mời bạn nhập ID Project: ");
        String projectId = scanner.nextLine();
        List<User> users = userController.getListUserById(projectId);
        if(users != null){
            for(User user: users){
                System.out.printf("%-15s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),user.getRole());
            }
        }
    }

    public void addEmpolyee() throws ClassNotFoundException, SQLException {
        System.out.print("Mời bạn nhập fullname cua account: ");
        String fullname = scanner.nextLine();
        System.out.print("moi ban nhap password cua account: ");
        String password = ScannerUtils.inputPassword();
        System.out.print("moi ban nhap expInYear cua account: ");
        int expInYear = ScannerUtils.inputFunction(0, 10);
        System.out.print("moi ban nhap proSkill cua account: ");
        String proSkill = scanner.nextLine();
        System.out.print("moi ban nhap ProjectId cua account: ");
        String ProjectId = scanner.nextLine();

        System.out.print("moi ban nhap vao Email cua account: ");
        // a@gmail.com	a@gmail.com
        //  123456A	    A654321
        String email = "";
        while (true) {
            email = ScannerUtils.inputEmail();// kiem tra dung dịnh dang email chua
            boolean resultExistsEmail = userController.isUserExistsByEmail(email); // kiem tra xem email có bi trung hayko
            // tao 2 tk giong ý chang nhau( giong email: a@gmail.com và gióng password: 123456)   tk1 và tk2
            if (resultExistsEmail) {
                System.err.printf("\nEmail %s da ton tai! moi nhap email mail khac: ", email);
            } else {
                break;
            }
        }

        boolean check = userController.registerE(fullname,email,password,expInYear,proSkill,ProjectId);
        if (check)
            System.out.println("Tạo mới Employee thành công");
        else
            System.out.println("Tạo Employee khong thành công");
    }
    public void getListUser() throws ClassNotFoundException, SQLException {
        List<User> users = userController.getListUser();
        if (users != null) {
            for (User user : users) {
                System.out.printf("%-15s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),user.getRole());
            }

        }
    }


    public void login() throws SQLException, ClassNotFoundException {
        while (true) {
            System.out.print("Mời bạn nhập Email: ");
            String email = ScannerUtils.inputEmail();

            System.out.print("Mời bạn nhập password: ");
            String password = ScannerUtils.inputPassword();

            User user = userController.login(email, password);

            if (user != null) {
                System.out.printf("Chao mung %s (%s) \n \n \n",
                        user.getFullName(), user.getRole());
                return;
            } else {
                System.err.println("Ban xem lai Email/Password ko dung! moi dang nhap lai!");
            }
        }
    }




    public void menu() throws SQLException, ClassNotFoundException {
        while (true) {
            Function function = new Function();
            System.out.println("Mời bạn chọn chức năng: ");
            System.out.println("1. Nhập vào ID Project, in ra thông tin Employee");
            System.out.println("2. Hiện ra thông tin Manager");
            System.out.println("3. Đăng kí(Employee)");
            System.out.println("4. Login");


            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    function.getListUserById();
                    break;
                case 2:
                    function.getListUser();
                    break;
                case 3:
                    function.addEmpolyee();
                    break;
                case 4:
                    System.out.println("Mời bạn đăng nhập");
                    function.login();
                    break;

            }
        }
    }
}
