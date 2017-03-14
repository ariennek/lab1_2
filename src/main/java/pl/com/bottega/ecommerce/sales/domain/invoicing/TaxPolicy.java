package pl.com.bottega.ecommerce.sales.domain.invoicing;

/**
 * Created by pebuls on 13.03.17.
 */
public interface TaxPolicy {

    public Tax taxCalculator(RequestItem requestItem);
}
