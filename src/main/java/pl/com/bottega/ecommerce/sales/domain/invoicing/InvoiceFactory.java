package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

/**
 * Created by RFran on 14.03.2017.
 */
public class InvoiceFactory {

    public Invoice createNewInvoice(ClientData client){
        Invoice invoice = new Invoice(Id.generate(), client);

        return invoice;
    }

}
