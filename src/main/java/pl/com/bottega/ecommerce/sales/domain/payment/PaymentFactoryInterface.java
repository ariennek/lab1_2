package pl.com.bottega.ecommerce.sales.domain.payment;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by Krzysztof Zimny on 3/19/2017.
 */
public interface PaymentFactoryInterface {
    Payment createPayment(ClientData clientData, Money money);
}

