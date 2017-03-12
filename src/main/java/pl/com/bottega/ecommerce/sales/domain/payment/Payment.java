package pl.com.bottega.ecommerce.sales.domain.payment;
 
 import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
 import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
 import pl.com.bottega.ecommerce.sharedkernel.Money;
 
 public class Payment {
 
 	private ClientData clientData;
 	private Money money;
 	private PaymentFactory paymentFactory;
 	private Id aggregateId;
 
 
 	Payment(Id aggregateId, ClientData clientData, Money money) {
 		this.aggregateId = aggregateId;
 		this.clientData = clientData;
 		this.money = money;
 	}
 
 	public Payment rollBack() {
 
 		return paymentFactory.createPayment(clientData, money.multiplyBy(-1));
 	}
 }