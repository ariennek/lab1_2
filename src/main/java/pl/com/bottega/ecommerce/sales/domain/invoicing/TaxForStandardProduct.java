package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TaxForStandardProduct implements ITaxStrategy {

	public Tax calculateTax(ProductType type, Money net) {
		BigDecimal ratio = BigDecimal.valueOf(0.23);
		String desc = "23%";

		Money taxValue = net.multiplyBy(ratio);

		Tax tax = new Tax(taxValue, desc);

		return tax;
	}

}
