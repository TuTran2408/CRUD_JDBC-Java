package ultis;

import com.mysql.cj.util.StringUtils;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);
    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhập lại...");
            }
        }
    }
    public static int inputFunction(int a, int b) {// bat
        while (true) {
            int number = ScannerUtils.inputInt();
            if (number >= a && number <= b) {
                return number;
            } else {
                System.err.println("chỉ được nhập từ " + a + " đến " + b);
            }
        }
    }
    public static String inputString() {
        while (true) {
            String string = sc.nextLine();
            if (!StringUtils.isNullOrEmpty(string)) {
//				System.out.println(string);
                return string;
            } else {
                System.err.println("Nhập lại:");
            }
        }
    }
    public static String inputEmail() {
        while (true) {
            String email = sc.nextLine();
            if (email == null || !email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {// a@b
                System.out.print("Nhập lại: ");
            } else {
                return email;
            }
        }
    }

    public static String inputPassword() {
        while (true) {
            String password = ScannerUtils.inputString();
            if (password.length() < 6 || password.length() > 12) {
                System.out.print("Nhập lại: ");
                continue;
            }
            return password;
        }
    }
    public static String inputPhoneNumber() {

        System.out.println("Nhập vào số điện thoại");
//		sc.nextLine();
        while (true) {
            boolean isNumber = true;
            String number = ScannerUtils.inputString();

            if (number.length() > 12 || number.length() < 9) {
                isNumber = false;
            }
            if (number.charAt(0) != '0') {
                isNumber = false;
            }

            for (int i = 0; i < number.length(); i++) {
                if (Character.isDigit(number.charAt(i)) == false) {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber == true) {
                return number;
            } else {
                System.out.print("Nhập lại: ");
            }
        }
    }

    public static String inputFullName() {
        while (true) {
            String fullName = ScannerUtils.inputString();
            if (fullName == null
                    || !fullName.matches("^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
                    + "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨú"
                    + "ÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ \\\\ _-]{3,25}$")) {

                System.out.println("Nhập lại: ");

            } else {
                return fullName;
            }
        }
    }
}
