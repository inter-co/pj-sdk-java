package inter.functests;

import inter.functests.menus.BankingMenu;
import inter.functests.menus.BillingMenu;
import inter.functests.menus.PixMenu;
import inter.functests.utils.FuncTestUtils;
import inter.sdk.InterSdk;
import inter.sdk.commons.exceptions.InvalidEnvironmentException;
import inter.sdk.commons.exceptions.SdkException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class FunctionalTestRunner {

    public static void main(String[] args) throws SdkException {

        String environment = FuncTestUtils.getString("Environment (PRODUCTION, SANDBOX)");

        validateEnvironment(environment);

        InterSdk interSdk = getInterSdkData(environment);
        int op;
        while ((op = menu(environment)) != 0) {
            try {
                switch (op) {
                    case 1:
                        while ((op = BillingMenu.showMenu(environment)) != 0) {
                            BillingMenu.execute(op, interSdk);
                        }
                        break;
                    case 2:
                        while ((op = BankingMenu.showMenu(environment)) != 0) {
                            BankingMenu.execute(op, interSdk);
                        }
                        break;
                    case 3:
                        while ((op = PixMenu.showMenu(environment)) != 0) {
                            PixMenu.execute(op, interSdk);
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("An error occurred: ");
                System.out.println(e.getMessage());
            }

        }
    }

    private static void validateEnvironment(String environment) throws InvalidEnvironmentException {
        List<String> environments = Arrays.asList("PRODUCTION", "SANDBOX", "UAT");

        if (!environments.contains(environment)) {
            throw new InvalidEnvironmentException();
        }
    }

    private static InterSdk getInterSdkData(String environment) throws SdkException {
        String clientId = FuncTestUtils.getString("Integration clientId");;
        String clientSecret = FuncTestUtils.getString("Integration clientSecret");
        String certificate = FuncTestUtils.getString("Path of the file with the pfx certificate (ex: src/main/java/inter/certificates/production.pfx)");
        String password = FuncTestUtils.getString("Password of the file with the pfx certificate");
        String account = FuncTestUtils.getString("Account");

        InterSdk interSdk = new InterSdk(environment, clientId, clientSecret, certificate, password);
        interSdk.setAccount(account);
        return interSdk;
    }

    private static int menu(String environment) {
        System.out.println("ENVIRONMENT " + environment);
        System.out.println("1 - API Billing");
        System.out.println("2 - API Banking");
        System.out.println("3 - API Pix");
        System.out.println("0 - Exit");
        System.out.print("=> ");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid option");

            return menu(environment);
        }
    }
}