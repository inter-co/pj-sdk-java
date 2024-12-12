package inter.functests.menus;

import com.fasterxml.jackson.core.JsonProcessingException;
import inter.functests.BankingFunctionalTests;
import inter.sdk.InterSdk;
import inter.sdk.commons.exceptions.SdkException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingMenu {
    private static final int RETRIEVE_STATEMENT = 1;
    private static final int RETRIEVE_STATEMENT_PDF = 2;
    private static final int RETRIEVE_ENRICHED_STATEMENT = 3;
    private static final int RETRIEVE_ENRICHED_STATEMENT_PAGINATION = 4;
    private static final int RETRIEVE_BALANCE = 5;
    private static final int INCLUDE_PAYMENT = 6;
    private static final int SEARCH_PAYMENTS = 7;
    private static final int INCLUDE_DARF_PAYMENT = 8;
    private static final int SEARCH_DARF_PAYMENTS = 9;
    private static final int INCLUDE_PAYMENT_BATCH = 10;
    private static final int SEARCH_PAYMENT_BATCH = 11;
    private static final int CANCEL_SCHEDULING = 12;
    private static final int INCLUDE_PIX_KEY = 13;
    private static final int GET_PIX = 14;
    private static final int CREATE_WEBHOOK = 15;
    private static final int GET_WEBHOOK = 16;
    private static final int DELETE_WEBHOOK = 17;
    private static final int RETRIEVE_CALLBACKS = 18;
    private static final int RETRIEVE_CALLBACKS_PAGINATION = 19;

    public static int showMenu(String environment) {
        System.out.println("ENVIRONMENT " + environment);
        System.out.println(RETRIEVE_STATEMENT + " - Retrieve Bank Statement");
        System.out.println(RETRIEVE_STATEMENT_PDF + " - Retrieve Bank Statement PDF");
        System.out.println(RETRIEVE_ENRICHED_STATEMENT + " - Retrieve Enriched Bank Statement");
        System.out.println(RETRIEVE_ENRICHED_STATEMENT_PAGINATION + " - Retrieve Enriched Bank Statement with pagination");
        System.out.println(RETRIEVE_BALANCE + " - Retrieve Balance (current day)");
        System.out.println(INCLUDE_PAYMENT + " - Include Payment for billet");
        System.out.println(SEARCH_PAYMENTS + " - Search Payments for billet");
        System.out.println(INCLUDE_DARF_PAYMENT + " - Include DARF Payment");
        System.out.println(SEARCH_DARF_PAYMENTS + " - Search DARF Payments");
        System.out.println(INCLUDE_PAYMENT_BATCH + " - Include Payments in Batch");
        System.out.println(SEARCH_PAYMENT_BATCH + " - Search Payment Batch");
        System.out.println(CANCEL_SCHEDULING + " - Cancel payment scheduling");
        System.out.println(INCLUDE_PIX_KEY + " - Include Pix payment by Key");
        System.out.println(GET_PIX + " - Get Pix payment details");
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
            System.out.println("invalid option");
            return showMenu(environment);
        }
    }
    public static void execute(int op, InterSdk interSdk) throws SdkException, JsonProcessingException {
        BankingFunctionalTests bankingFunctionalTests = new BankingFunctionalTests(interSdk);
        switch (op) {
            case RETRIEVE_STATEMENT:
                bankingFunctionalTests.testBankingStatement();
                break;
            case RETRIEVE_STATEMENT_PDF:
                bankingFunctionalTests.testBankingStatementPdf();
                break;
            case RETRIEVE_ENRICHED_STATEMENT:
                bankingFunctionalTests.testBankingEnrichedStatement();
                break;
            case RETRIEVE_ENRICHED_STATEMENT_PAGINATION:
                bankingFunctionalTests.testBankingEnrichedStatementPage();
                break;
            case RETRIEVE_BALANCE:
                bankingFunctionalTests.testBankingBalance();
                break;
            case INCLUDE_PAYMENT:
                bankingFunctionalTests.testBankingIncludePayment();
                break;
            case SEARCH_PAYMENTS:
                bankingFunctionalTests.testBankingRetrievePaymentList();
                break;
            case INCLUDE_DARF_PAYMENT:
                bankingFunctionalTests.testBankingIncludeDarfPayment();
                break;
            case SEARCH_DARF_PAYMENTS:
                bankingFunctionalTests.testBankingRetrieveDarfPayment();
                break;
            case INCLUDE_PAYMENT_BATCH:
                bankingFunctionalTests.testBankingIncludePaymentBatch();
                break;
            case CANCEL_SCHEDULING:
                bankingFunctionalTests.testBankingCancelPayment();
                break;
            case SEARCH_PAYMENT_BATCH:
                bankingFunctionalTests.testBankingRetrievePaymentBatch();
                break;
            case INCLUDE_PIX_KEY:
                bankingFunctionalTests.testBankingIncludePix();
                break;
            case GET_PIX:
                bankingFunctionalTests.testBankingRetrievePix();
                break;
            case CREATE_WEBHOOK:
                bankingFunctionalTests.testBankingIncludeWebhook();
                break;
            case GET_WEBHOOK:
                bankingFunctionalTests.testBankingRetrieveWebhook();
                break;
            case DELETE_WEBHOOK:
                bankingFunctionalTests.testBankingDeleteWebhook();
                break;
            case RETRIEVE_CALLBACKS:
                bankingFunctionalTests.testBankingRetrieveCallbacks();
                break;
            case RETRIEVE_CALLBACKS_PAGINATION:
                bankingFunctionalTests.testBankingRetrieveCallback();
                break;
        }
        System.out.println();
    }
}