package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by RFran on 14.03.2017.
 */
public interface ITaxCalculation {
    Tax calculate(ProductType productType, Money net);
}
