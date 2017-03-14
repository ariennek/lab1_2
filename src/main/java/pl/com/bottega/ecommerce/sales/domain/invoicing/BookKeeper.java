/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;
import java.util.List;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class BookKeeper {
	
	InvoiceFactory invoiceFactory;
	
	
	public Invoice issuance(InvoiceRequest invoiceRequest) {	
	
		Invoice invoice = invoiceFactory.create(Id.generate(), invoiceRequest.getClient());
				

		for (RequestItem item : invoiceRequest.getItems()) {
			
			Money net = item.getTotalCost();
			
			
			taxCreator creator;
			ProductType pType = item.getProductData().getType();
			
			Tax tax = taxCalc(pType, net);
			InvoiceLine invoiceLine = new InvoiceLine(item.getProductData(),
					item.getQuantity(), net, tax);
			invoice.addItem(invoiceLine);
		}

		return invoice;
	}


	private Tax taxCalc(ProductType pType, Money net) {
		
		taxCreator creator;
		
		switch (pType) {
		case DRUG:				
			creator = new taxCreatorDrugs();
			break;
		case FOOD:
			creator = new taxCreatorFood();
			break;
		case STANDARD:
			creator = new taxCreatorStandard();
			break;
			
		default:
			throw new IllegalArgumentException(pType + " not handled");
		}
		
		return creator.create(net);
	}

}
