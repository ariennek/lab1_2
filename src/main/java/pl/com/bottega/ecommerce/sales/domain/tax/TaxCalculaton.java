package pl.com.bottega.ecommerce.sales.domain.tax;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

/**
 * Created by Krzysztof Zimny on 3/19/2017.
 */
public class TaxCalculaton implements TaxCalculationInterface {

    private static final BigDecimal DRUG_RATIO = BigDecimal.valueOf(0.05);
    private static final String DRUG_DESC = "5% (D)";

    private static final BigDecimal FOOD_RATIO = BigDecimal.valueOf(0.07);
    private static final String FOOD_DESC = "7% (F)";

    private static final BigDecimal STANDARD_RATIO = BigDecimal.valueOf(0.23);
    private static final String STANDARD_DESC = "23%";

    public Tax calculateTax(ProductType productType, Money money) {

        BigDecimal ratio = null;
        String desc = null;

        switch (productType) {
            case DRUG:
                ratio = DRUG_RATIO;
                desc = DRUG_DESC;
                break;
            case FOOD:
                ratio = FOOD_RATIO;
                desc = FOOD_DESC;
                break;
            case STANDARD:
                ratio = STANDARD_RATIO;
                desc = STANDARD_DESC;
                break;

            default:
                throw new IllegalArgumentException(productType + " not handled");
        }

        Money value = money.multiplyBy(ratio);

        return new Tax(value, desc);
    }
}
