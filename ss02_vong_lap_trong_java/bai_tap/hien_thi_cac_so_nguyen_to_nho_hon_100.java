public class hien_thi_cac_so_nguyen_to_nho_hon_100 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100: ");
        boolean check;
        System.out.println("2 là số nguyên tố");
        System.out.println("3 là số nguyên tố");

        for (int i = 4; i < 100; i++) {
            check = true;
            if (i % 2 == 0) {
                check = false;
            } else {
                for (int j = 3; j < i; j++) {
                    if (i % j == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                System.out.println(i + " là số nguyên tố");
            }
        }
    }
}
