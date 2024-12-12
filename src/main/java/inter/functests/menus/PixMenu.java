package inter.functests.menus;

import com.fasterxml.jackson.core.JsonProcessingException;
import inter.functests.PixFunctionalTests;
import inter.sdk.InterSdk;
import inter.sdk.commons.exceptions.SdkException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PixMenu {
    private static final int CREATE_IMMEDIATE_BILLING = 1;
    private static final int CREATE_IMMEDIATE_BILLING_TXID = 2;
    private static final int REVIEW_IMMEDIATE_BILLING = 3;
    private static final int RETRIEVE_IMMEDIATE_BILLING = 4;
    private static final int RETRIEVE_IMMEDIATE_BILLINGS = 5;
    private static final int RETRIEVE_IMMEDIATE_BILLINGS_PAGINATION = 6;
    private static final int CREATE_DUE_BILLING = 7;
    private static final int REVIEW_DUE_BILLING = 8;
    private static final int RETRIEVE_DUE_BILLING = 9;
    private static final int RETRIEVE_DUE_BILLINGS = 10;
    private static final int RETRIEVE_DUE_BILLINGS_PAGINATION = 11;
    private static final int CREATE_LOCATION = 12;
    private static final int RETRIEVE_LOCATION = 13;
    private static final int UNLINK_LOCATION = 14;
    private static final int RETRIEVE_REGISTERED_LOCATIONS = 15;
    private static final int RETRIEVE_REGISTERED_LOCATIONS_PAGINATION = 16;
    private static final int RETRIEVE_PIX = 17;
    private static final int RETRIEVE_RECEIVED_PIX = 18;
    private static final int RETRIEVE_RECEIVED_PIX_PAGINATION = 19;
    private static final int REQUEST_PIX_DEVOLUTION = 20;
    private static final int RETRIEVE_PIX_DEVOLUTION = 21;
    private static final int CREATE_WEBHOOK = 22;
    private static final int GET_WEBHOOK = 23;
    private static final int DELETE_WEBHOOK = 24;
    private static final int RETRIEVE_CALLBACKS = 25;
    private static final int RETRIEVE_CALLBACKS_PAGINATION = 26;
    private static final int RETRIEVE_DUE_BILLING_BATCH = 27;
    private static final int RETRIEVE_DUE_BILLING_BATCH_PAGINATION = 28;
    private static final int RETRIEVE_DUE_BILLING_BATCHES = 29;
    private static final int RETRIEVE_DUE_BILLING_BATCH_SUMMARY = 30;
    private static final int RETRIEVE_DUE_BILLING_BATCH_SITUATION = 31;
    private static final int CREATE_DUE_BILLING_BATCH = 32;
    private static final int REVIEW_DUE_BILLING_BATCH = 33;

    public static int showMenu(String environment) {
        System.out.println("ENVIRONMENT " + environment);
        System.out.println(CREATE_IMMEDIATE_BILLING + " - Create Immediate Billing");
        System.out.println(CREATE_IMMEDIATE_BILLING_TXID + " - Create Immediate Billing TxId");
        System.out.println(REVIEW_IMMEDIATE_BILLING + " - Review Immediate Billing");
        System.out.println(RETRIEVE_IMMEDIATE_BILLING + " - Retrieve Immediate Billing by TxId");
        System.out.println(RETRIEVE_IMMEDIATE_BILLINGS + " - Retrieve Immediate Billings");
        System.out.println(RETRIEVE_IMMEDIATE_BILLINGS_PAGINATION + " - Retrieve Immediate Billings with pagination");
        System.out.println(CREATE_DUE_BILLING + " - Create Due Billing");
        System.out.println(REVIEW_DUE_BILLING + " - Review Due Billing");
        System.out.println(RETRIEVE_DUE_BILLING + " - Retrieve Due Billing by TxId");
        System.out.println(RETRIEVE_DUE_BILLINGS + " - Retrieve Due Billings");
        System.out.println(RETRIEVE_DUE_BILLINGS_PAGINATION + " - Retrieve Due Billings with pagination");
        System.out.println(CREATE_LOCATION + " - Create Location");
        System.out.println(RETRIEVE_LOCATION + " - Retrieve Location");
        System.out.println(UNLINK_LOCATION + " - Unlink Location");
        System.out.println(RETRIEVE_REGISTERED_LOCATIONS + " - Retrieve Registered Locations");
        System.out.println(RETRIEVE_REGISTERED_LOCATIONS_PAGINATION + " - Retrieve Registered Locations with pagination");
        System.out.println(RETRIEVE_PIX + " - Retrieve Pix by e2eId");
        System.out.println(RETRIEVE_RECEIVED_PIX + " - Retrieve Received Pix");
        System.out.println(RETRIEVE_RECEIVED_PIX_PAGINATION + " - Retrieve Received Pix with pagination");
        System.out.println(REQUEST_PIX_DEVOLUTION + " - Request Devolution");
        System.out.println(RETRIEVE_PIX_DEVOLUTION + " - Retrieve Devolution");
        System.out.println(CREATE_WEBHOOK + " - Create Webhook");
        System.out.println(GET_WEBHOOK + " - Get Webhook");
        System.out.println(DELETE_WEBHOOK + " - Delete Webhook");
        System.out.println(RETRIEVE_CALLBACKS + " - Retrieve callbacks");
        System.out.println(RETRIEVE_CALLBACKS_PAGINATION + " - Retrieve callbacks with pagination");
        System.out.println(RETRIEVE_DUE_BILLING_BATCH + " - Retrieve Due Billing Batch");
        System.out.println(RETRIEVE_DUE_BILLING_BATCH_PAGINATION + " - Retrieve Due Billing Batch - Pagination");
        System.out.println(RETRIEVE_DUE_BILLING_BATCHES + " - Retrieve Due Billing Batches");
        System.out.println(RETRIEVE_DUE_BILLING_BATCH_SUMMARY + " - Retrieve Due Billing Batch - Summary");
        System.out.println(RETRIEVE_DUE_BILLING_BATCH_SITUATION + " - Retrieve Due Billing Batch - Situation");
        System.out.println(CREATE_DUE_BILLING_BATCH + " - Create Due Billing Batch");
        System.out.println(REVIEW_DUE_BILLING_BATCH + " - Review Due Billing Batch");
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
        PixFunctionalTests pixFunctionalTests = new PixFunctionalTests(interSdk);
        switch (op) {
            case CREATE_IMMEDIATE_BILLING:
                pixFunctionalTests.testPixIncludeImmediateBilling();
                break;
            case REVIEW_IMMEDIATE_BILLING:
                pixFunctionalTests.testPixReviewImmediateBilling();
                break;
            case RETRIEVE_IMMEDIATE_BILLING:
                pixFunctionalTests.testPixRetrieveImmediateBilling();
                break;
            case CREATE_IMMEDIATE_BILLING_TXID:
                pixFunctionalTests.testPixIncludeImmediateBillingTxId();
                break;
            case RETRIEVE_IMMEDIATE_BILLINGS:
                pixFunctionalTests.testPixRetrieveImmediateBillingCollection();
                break;
            case RETRIEVE_IMMEDIATE_BILLINGS_PAGINATION:
                pixFunctionalTests.testPixRetrieveImmediateBillingCollectionPage();
                break;
            case CREATE_DUE_BILLING:
                pixFunctionalTests.testPixIncludeDueBilling();
                break;
            case REVIEW_DUE_BILLING:
                pixFunctionalTests.testPixReviewDueBilling();
                break;
            case RETRIEVE_DUE_BILLING:
                pixFunctionalTests.testPixRetrieveDueBilling();
                break;
            case RETRIEVE_DUE_BILLINGS:
                pixFunctionalTests.testPixRetrieveDueBillingCollection();
                break;
            case RETRIEVE_DUE_BILLINGS_PAGINATION:
                pixFunctionalTests.testPixRetrieveDueBillingCollectionPage();
                break;
            case CREATE_LOCATION:
                pixFunctionalTests.testPixIncludeLocation();
                break;
            case RETRIEVE_REGISTERED_LOCATIONS:
                pixFunctionalTests.testPixRetrieveLocationList();
                break;
            case RETRIEVE_REGISTERED_LOCATIONS_PAGINATION:
                pixFunctionalTests.testPixRetrieveLocationListPage();
                break;
            case RETRIEVE_LOCATION:
                pixFunctionalTests.testPixRetrieveLocation();
                break;
            case UNLINK_LOCATION:
                pixFunctionalTests.testPixUnlinkLocation();
                break;
            case RETRIEVE_PIX:
                pixFunctionalTests.testPixRetrievePix();
                break;
            case RETRIEVE_RECEIVED_PIX:
                pixFunctionalTests.testPixRetrievePixList();
                break;
            case RETRIEVE_RECEIVED_PIX_PAGINATION:
                pixFunctionalTests.testPixRetrievePixListPage();
                break;
            case REQUEST_PIX_DEVOLUTION:
                pixFunctionalTests.testPixRequestDevolution();
                break;
            case RETRIEVE_PIX_DEVOLUTION:
                pixFunctionalTests.testPixRetrieveDevolution();
                break;
            case CREATE_WEBHOOK:
                pixFunctionalTests.testBillingIncludeWebhook();
                break;
            case GET_WEBHOOK:
                pixFunctionalTests.testBillingRetrieveWebhook();
                break;
            case DELETE_WEBHOOK:
                pixFunctionalTests.testBillingDeleteWebhook();
                break;
            case RETRIEVE_CALLBACKS:
                pixFunctionalTests.testBillingRetrieveCallbacks();
                break;
            case RETRIEVE_CALLBACKS_PAGINATION:
                pixFunctionalTests.testBillingRetrieveCallbacksPage();
                break;
            case RETRIEVE_DUE_BILLING_BATCH:
                pixFunctionalTests.testPixRetrieveDueBillingBatch();
                break;
            case RETRIEVE_DUE_BILLING_BATCH_PAGINATION:
                pixFunctionalTests.testPixRetrieveDueBillingBatchCollectionPage();
                break;
            case RETRIEVE_DUE_BILLING_BATCHES:
                pixFunctionalTests.testPixRetrieveDueBillingBatchCollection();
                break;
            case RETRIEVE_DUE_BILLING_BATCH_SUMMARY:
                pixFunctionalTests.testPixRetrieveDueBillingBatchSummary();
                break;
            case RETRIEVE_DUE_BILLING_BATCH_SITUATION:
                pixFunctionalTests.testPixRetrieveDueBillingBatchBySituation();
                break;
            case CREATE_DUE_BILLING_BATCH:
                pixFunctionalTests.testPixIncludeDueBillingBatch();
                break;
            case REVIEW_DUE_BILLING_BATCH:
                pixFunctionalTests.testPixReviewDueBillingBatch();
                break;
        }
        System.out.println();
    }
}