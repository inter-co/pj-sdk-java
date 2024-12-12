package inter.functests.menus;

import com.fasterxml.jackson.core.JsonProcessingException;
import inter.functests.BillingFunctionalTests;
import inter.sdk.InterSdk;
import inter.sdk.commons.exceptions.SdkException;

import java.util.InputMismatchException;
import java.util.Scanner;
public class BillingMenu {
    private static final int ISSUE_BILLING = 1;
    private static final int RETRIEVE_BILLINGS = 2;
    private static final int RETRIEVE_BILLING_PAGINATION = 3;
    private static final int RETRIEVE_BILLING_SUMMARY = 4;
    private static final int RETRIEVE_DETAILED_BILLING = 5;
    private static final int RETRIEVE_BILLING_PDF = 6;
    private static final int CANCEL_BILLING = 7;
    private static final int CREATE_WEBHOOK = 8;
    private static final int GET_WEBHOOK = 9;
    private static final int DELETE_WEBHOOK = 10;
    private static final int RETRIEVE_CALLBACKS = 11;
    private static final int RETRIEVE_CALLBACKS_PAGINATION = 12;

    public static int showMenu(String environment) {
        System.out.println("ENVIRONMENT " + environment);
        System.out.println(ISSUE_BILLING + " - Issue Billing");
        System.out.println(RETRIEVE_BILLINGS + " - Retrieve Billings");
        System.out.println(RETRIEVE_BILLING_PAGINATION + " - Retrieve Billing with pagination");
        System.out.println(RETRIEVE_BILLING_SUMMARY + " - Retrieve Billing Summary");
        System.out.println(RETRIEVE_DETAILED_BILLING + " - Retrieve Detailed Billing");
        System.out.println(RETRIEVE_BILLING_PDF + " - Retrieve Billing PDF");
        System.out.println(CANCEL_BILLING + " - Cancel Billing");
        System.out.println(CREATE_WEBHOOK + " - Create Webhook");
        System.out.println(GET_WEBHOOK + " - Get Webhook");
        System.out.println(DELETE_WEBHOOK + " - Delete Webhook");
        System.out.println(RETRIEVE_CALLBACKS + " - Retrieve callbacks");
        System.out.println(RETRIEVE_CALLBACKS_PAGINATION + " - Retrieve callbacks with pagination");
        System.out.println("0 - Exit");
        System.out.print("=> ");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid option");
            return showMenu(environment);
        }
    }

    public static void execute(int op, InterSdk interSdk) throws SdkException, JsonProcessingException {
        BillingFunctionalTests billingFunctionalTests = new BillingFunctionalTests(interSdk);
        switch (op) {
            case ISSUE_BILLING:
                billingFunctionalTests.testBillingIssueBilling();
                break;
            case RETRIEVE_BILLINGS:
                billingFunctionalTests.testBillingRetrieveBillingCollection();
                break;
            case RETRIEVE_BILLING_PAGINATION:
                billingFunctionalTests.testBillingRetrieveBillingCollectionPage();
                break;
            case RETRIEVE_BILLING_SUMMARY:
                billingFunctionalTests.testBillingRetrieveBillingSummary();
                break;
            case RETRIEVE_DETAILED_BILLING:
                billingFunctionalTests.testBillingRetrieveBilling();
                break;
            case RETRIEVE_BILLING_PDF:
                billingFunctionalTests.testBillingRetrieveBillingPdf();
                break;
            case CANCEL_BILLING:
                billingFunctionalTests.testBillingCancelBilling();
                break;
            case CREATE_WEBHOOK:
                billingFunctionalTests.testBillingIncludeWebhook();
                break;
            case GET_WEBHOOK:
                billingFunctionalTests.testBillingRetrieveWebhook();
                break;
            case DELETE_WEBHOOK:
                billingFunctionalTests.testBillingDeleteWebhook();
                break;
            case RETRIEVE_CALLBACKS:
                billingFunctionalTests.testBillingRetrieveCallbacks();
                break;
            case RETRIEVE_CALLBACKS_PAGINATION:
                billingFunctionalTests.testBillingRetrieveCallbacksPage();
                break;
        }
        System.out.println();
    }
}