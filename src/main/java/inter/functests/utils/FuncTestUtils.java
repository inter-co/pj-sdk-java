package inter.functests.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class FuncTestUtils {
    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static BigDecimal getBigDecimal(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);

        return BigDecimal.valueOf(Double.parseDouble(scanner.next()));
    }
}
