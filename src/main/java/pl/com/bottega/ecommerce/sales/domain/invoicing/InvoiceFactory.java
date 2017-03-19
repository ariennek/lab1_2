package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

/**
 * Created by Krzysztof Zimny on 3/19/2017.
 */
public class InvoiceFactory implements InvoiceFactoryInterface {

    public Invoice createInvoice(ClientData clientData) {
        Id id = Id.generate();
        return new Invoice(id, clientData);
    }
}
