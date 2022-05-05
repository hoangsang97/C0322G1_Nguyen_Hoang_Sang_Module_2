import java.util.Scanner;

public class txt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;
        do {
            password = sc.nextLine();
        } while (!password.equals("vung oi mo ra"));
    }
}
