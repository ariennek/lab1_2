package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

/**
 * Created by pebuls on 13.03.17.
 */
public class InvoiceFactory {

    public static Invoice createInvoice(Id invoiceId, ClientData client) {
        return new Invoice(invoiceId, client);
    }
}
