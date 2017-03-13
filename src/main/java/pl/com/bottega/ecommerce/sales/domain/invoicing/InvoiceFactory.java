/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 *
 * @author jankowskirobert
 */
public class InvoiceFactory {
    
    public static Invoice getInstance(Id invoiceId, ClientData client) {
        return new Invoicing(invoiceId, client);
    }
    private static class Invoicing implements Invoice {


	private ClientData client;


	private Money net;

	private Money gros;

	private List<InvoiceLine> items;


	private Id id;

	private Invoicing(Id invoiceId, ClientData client) {
		this.id = invoiceId;
		this.client = client;
		this.items = new ArrayList<InvoiceLine>();
		
		this.net = Money.ZERO;
		this.gros = Money.ZERO;
	}
	

	public void addItem(InvoiceLine item) {
		items.add(item);

		net = net.add(item.getNet());
		gros = gros.add(item.getGros());
	}

	/**
	 * 
	 * @return immutable projection
	 */
	public List<InvoiceLine> getItems() {
		return Collections.unmodifiableList(items);
	}

	public ClientData getClient() {
		return client;
	}

	public Money getNet() {
		return net;
	}

	public Money getGros() {
		return gros;
	}

}

}
