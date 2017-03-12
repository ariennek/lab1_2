package pl.com.bottega.ecommerce.sales.domain.invoicing;
 
 import java.math.BigDecimal;
 
 import pl.com.bottega.ecommerce.sharedkernel.Money;
 
 public class BookKeeper {
 	
 	private InvoiceFactory iFactory;
 	
 	public Invoice issuance(InvoiceRequest request) {
 		Invoice invoice = iFactory.create(request.getClient());
 
 		for (RequestItem item : request.getItems()) {
 			Money net = item.getTotalCost();
 			BigDecimal ratio = null;
 			String desc = null;
 			
 			switch (item.getProductData().getType()) {
 			case DRUG:
 				ratio = BigDecimal.valueOf(0.05);
 				desc = "5% (D)";
 				break;
 			case FOOD:
 				ratio = BigDecimal.valueOf(0.07);
 				desc = "7% (F)";
 				break;
 			case STANDARD:
 				ratio = BigDecimal.valueOf(0.23);
 				desc = "23%";
 				break;
 				
 			default:
 				throw new IllegalArgumentException(item.getProductData().getType() + " not handled");
 			}
 					
 			Money taxValue = net.multiplyBy(ratio);
 			
 			Tax tax = new Tax(taxValue, desc);
 			
 
 			InvoiceLine invoiceLine = new InvoiceLine(item.getProductData(),
 					item.getQuantity(), net, tax);
 			invoice.addItem(invoiceLine);
 		}
 
 		return invoice;
 	}
 
 }