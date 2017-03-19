package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;

/**
 * Created by Krzysztof Zimny on 3/19/2017.
 */
public interface InvoiceFactoryInterface {
    Invoice createInvoice(ClientData clientData);
}
