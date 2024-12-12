package inter.sdk.commons.structures;

public abstract class Constants {
    public static final String DOC_CERTIFICATE = "https://developers.bancointer.com.br/v4/docs/onde-obter-o-certificado";

    public static final String URL_BANKING = "/banking/v2";
    public static final String URL_BANKING_BALANCE = URL_BANKING + "/saldo";

    public static final String URL_TOKEN = "/oauth/v2/token";

    public static final String URL_BANKING_STATEMENT = URL_BANKING + "/extrato";
    public static final String URL_BANKING_ENRICHED_STATEMENT = URL_BANKING_STATEMENT + "/completo";
    public static final String URL_BANKING_STATEMENT_PDF = URL_BANKING_STATEMENT + "/exportar";
    public static final String URL_BANKING_PAYMENT = URL_BANKING + "/pagamento";
    public static final String URL_BANKING_PAYMENT_DARF = URL_BANKING_PAYMENT + "/darf";
    public static final String URL_BANKING_PAYMENT_BATCH = URL_BANKING_PAYMENT + "/lote";
    public static final String URL_BANKING_PAYMENT_PIX = URL_BANKING + "/pix";
    public static final String URL_BANKING_WEBHOOK = URL_BANKING + "/webhooks";

    public static final String URL_PIX = "/pix/v2";
    public static final String URL_PIX_PIX = URL_PIX + "/pix";
    public static final String URL_PIX_LOCATIONS = URL_PIX + "/loc";
    public static final String URL_PIX_IMMEDIATE_BILLINGS = URL_PIX + "/cob";
    public static final String URL_PIX_SCHEDULED_BILLINGS = URL_PIX + "/cobv";
    public static final String URL_PIX_SCHEDULED_BILLINGS_BATCH = URL_PIX + "/lotecobv";
    public static final String URL_PIX_WEBHOOK = URL_PIX + "/webhook";
    public static final String URL_PIX_WEBHOOK_CALLBACKS = URL_PIX_WEBHOOK + "/callbacks";

    public static final String URL_BILLING = "/cobranca/v3/cobrancas";
    public static final String URL_BILLING_SUMMARY = URL_BILLING + "/sumario";
    public static final String URL_BILLING_WEBHOOK = URL_BILLING + "/webhook";
    public static final String URL_BILLING_WEBHOOK_CALLBACKS = URL_BILLING_WEBHOOK + "/callbacks";

    public static final String BILLET_BILLING_READ_SCOPE = "boleto-cobranca.read";
    public static final String BILLET_BILLING_WRITE_SCOPE = "boleto-cobranca.write";

    public static final String READ_BALANCE_SCOPE = "extrato.read";
    public static final String BILLET_PAYMENT_READ_SCOPE = "pagamento-boleto.read";
    public static final String BILLET_PAYMENT_WRITE_SCOPE = "pagamento-boleto.write";
    public static final String DARF_PAYMENT_WRITE_SCOPE = "pagamento-darf.write";
    public static final String BATCH_PAYMENT_READ_SCOPE = "pagamento-lote.read";
    public static final String BATCH_PAYMENT_WRITE_SCOPE = "pagamento-lote.write";
    public static final String PIX_PAYMENT_WRITE_SCOPE = "pagamento-pix.write";
    public static final String PIX_PAYMENT_READ_SCOPE = "pagamento-pix.read";
    public static final String WEBHOOK_BANKING_READ_SCOPE = "webhook-banking.read";
    public static final String WEBHOOK_BANKING_WRITE_SCOPE = "webhook-banking.write";

    public static final String PIX_IMMEDIATE_BILLING_READ_SCOPE = "cob.read";
    public static final String PIX_IMMEDIATE_BILLING_WRITE_SCOPE = "cob.write";
    public static final String PIX_SCHEDULED_BILLING_READ_SCOPE = "cobv.read";
    public static final String PIX_SCHEDULED_BILLING_WRITE_SCOPE = "cobv.write";
    public static final String PIX_SCHEDULED_BILLING_BATCH_WRITE_SCOPE = "lotecobv.write";
    public static final String PIX_SCHEDULED_BILLING_BATCH_READ_SCOPE = "lotecobv.read";
    public static final String PIX_READ_SCOPE = "pix.read";
    public static final String PIX_WRITE_SCOPE = "pix.write";
    public static final String PIX_LOCATION_READ_SCOPE = "payloadlocation.read";
    public static final String PIX_LOCATION_WRITE_SCOPE = "payloadlocation.write";
    public static final String PIX_WEBHOOK_READ_SCOPE = "webhook.read";
    public static final String PIX_WEBHOOK_WRITE_SCOPE = "webhook.write";

    public static final int DAYS_TO_EXPIRE = 30;

    public static final String CERTIFICATE_EXCEPTION_MESSAGE = "Certificate error!";
    public static final String GENERIC_EXCEPTION_MESSAGE = "Error executing SDK!";
}