package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TaxForDrugProduct implements ITaxStrategy {

	public Tax calculateTax(ProductType type, Money net) {
		BigDecimal ratio = BigDecimal.valueOf(0.05);
		String desc = "5% (D)";

		Money taxValue = net.multiplyBy(ratio);

		Tax tax = new Tax(taxValue, desc);

		return tax;
	}

}