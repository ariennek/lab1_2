package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class taxCreatorDrugs implements taxCreator{

	public Tax create(Money money) {
		
		return new Tax(money.multiplyBy(BigDecimal.valueOf(0.05)), "5% (D)");
	}

}
