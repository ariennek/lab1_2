package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

/**
 * Created by RFran on 14.03.2017.
 */
public class TaxCalculation implements ITaxCalculation {
    public Tax calculate(ProductType productType, Money net){
        BigDecimal ratio = null;
        String desc = null;
        RequestItem item = new RequestItem(null, 0, net);

        switch (productType) {
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
                throw new IllegalArgumentException(productType + " not handled");
        }

        Money taxValue = net.multiplyBy(ratio);

        Tax tax = new Tax(taxValue, desc);

        return tax;
    }
}
