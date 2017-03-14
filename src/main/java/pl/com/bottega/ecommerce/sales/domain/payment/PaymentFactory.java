package pl.com.bottega.ecommerce.sales.domain.payment;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by RFran on 14.03.2017.
 */
public class PaymentFactory {

    public Payment createNewPayment(ClientData clientData, Money amount){
        Id aggregateId = Id.generate();

        return new Payment(aggregateId, clientData, amount);
    }
}
