package util.helper;

import main.MainRun;

import java.util.Scanner;

public class Helper {

    private static final String SPECIAL_CHAR_AND_NUMBER_REGEX = "[$&+,:;=?@#|'<>.-^*()%!0123456789]";
    private static final String SPECIAL_CHAR_REGEX = "[$&+,:;=?@#|'<>.-^*()%!]";

    public String getNormalizedString(String str) {
        str = normalize(str);
        String[] temp = str.split(" ");
        str = "";
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) // ? ^-^
                str += " ";
        }
        return str;
    }

    public String normalize(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }

    public boolean checkContainLetterOnly(String str) {
        return !str.equals("") && !str.matches(SPECIAL_CHAR_AND_NUMBER_REGEX);
    }

    public void printMenu() {
        System.out.println("""
                Nhập lựa chọn:
                [1] Quản lý lái xe.
                [2] Quản lý tuyến đường.
                [3] Quản lý bảng phân công.
                [4] Sắp xếp danh sách phân công.
                [5] Xem bảng thống kê khoảng cách chạy xe mỗi ngày.\s
                [6] Thoát chương  trình.""");
    }

    public void askContinue() {
        if (!askYesNo()) {
            MainRun.run = false;
        }
    }

    public int getInt(String ask) {
        boolean run = true;
        int a = 0;
        while (run) {
            try {
                System.out.println(ask);
                a = new Scanner(System.in).nextInt();
                run = false;

            } catch (Exception e) {
                System.out.println("Bạn phải nhập một số nguyên");
            }

        }

        return a;
    }

    public String getString(String ask) {
        boolean run = true;
        String s = "";
        while (run) {
            try {
                System.out.println(ask);
                s = new Scanner(System.in).nextLine();
                run = false;
            } catch (Exception e) {
                System.out.println("Bạn phải nhập một đoạn văn bản");
            }

        }
        return s;
    }

    public Double getDouble(String ask) {
        boolean run = true;
        Double d = 0.0;
        while (run) {
            try {
                System.out.println(ask);
                d = new Scanner(System.in).nextDouble();
                run = false;
            } catch (Exception e) {
                System.out.println("Bạn phải nhập một chữ số thập phân");
            }

        }
        return d;
    }

    public boolean askYesNo() {
        boolean ok = false;
        boolean runAgain = true;
        String ans;
        while (runAgain) {
            try {
                ans = getString("Bạn có muốn dùng tiếp chức năng khác không \n" +
                        "[C]  có\n" +
                        "[K]  không\n" +
                        "Chọn một trong 2 lựa chọn: ");
            } catch (Exception e) {
                // TODO: handle exceptions
                ans = getString("Bạn phải nhập [C] hoặc [K].");
            }
            if (ans.equalsIgnoreCase("C")) {
                ok = true;
                runAgain = false;
            } else if (ans.equalsIgnoreCase("K")) {
                runAgain = false;
            }


        }
        return ok;

    }
}
