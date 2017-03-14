package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class InvoiceCreator {
	
	public Invoice create(ClientData client){
		Invoice invoice = new Invoice(Id.generate(), client);
		
		return invoice;
	}
}
