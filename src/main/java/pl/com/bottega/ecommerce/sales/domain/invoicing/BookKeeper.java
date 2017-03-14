package pl.com.bottega.ecommerce.sales.domain.invoicing;
 
 import java.math.BigDecimal;
 
 import pl.com.bottega.ecommerce.sharedkernel.Money;
 
 public class BookKeeper {
 	
 	private InvoiceFactory iFactory;
 	private DefaultTaxPolicy dtPolicy;
 	
	public Invoice issuance(InvoiceRequest request) {
	 	return this.issuance(request, dtPolicy);
	}
 	
 		public Invoice issuance(InvoiceRequest request, TaxPolicy tPolicy) {
 		Invoice invoice = iFactory.create(request.getClient());
 
 		for (RequestItem item : request.getItems()) {
 			Money net = item.getTotalCost();
 			
 			Tax tax = tPolicy.calculateTax(item.getProductData().getType(), net);
 
 			InvoiceLine invoiceLine = new InvoiceLine(item.getProductData(),
 					item.getQuantity(), net, tax);
 			invoice.addItem(invoiceLine);
 		}
 
 		return invoice;
 	}
 }