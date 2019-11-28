package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {

        Product car = new Product("car");
        Product phone = new Product("phone");

        Item item = new Item(car, new BigDecimal(2), 10, new BigDecimal(100000));
        Item item1 = new Item(phone, new BigDecimal(3), 2, new BigDecimal(300));
        Item item2 = new Item(car, new BigDecimal(4), 3, new BigDecimal(4000));

        Invoice invoice = new Invoice("00001111");

        invoice.getItems().add(item);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        Assert.assertNotEquals(0, invoiceId);

        invoiceDao.deleteById(invoiceId);
    }
}
