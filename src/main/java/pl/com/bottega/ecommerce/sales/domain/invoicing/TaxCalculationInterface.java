package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by Krzysztof Zimny on 3/19/2017.
 */
public interface TaxCalculationInterface {
    Tax calculateTax(ProductType productType, Money money);
}
