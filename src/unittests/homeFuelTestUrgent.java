package unittests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import entity.Invoice;
import entity.OrderHomeFuel;
import entity.Rates;


public class homeFuelTestUrgent{

	@Test
	public void homeFuelTestUrgent() throws SQLException, ParseException {
	Invoice invoice1 = new Invoice();
	OrderHomeFuel homefuelorder1 = new OrderHomeFuel();
	Rates rates = new Rates();
	rates.setMaxHomeFuel((float) 5.23);
	
		homefuelorder1.setAddressToSupply("ort Braude");
		homefuelorder1.setInvitedById(1);
		homefuelorder1.setOrderId(1);
		homefuelorder1.setOrderType("600-800");
		homefuelorder1.setQuantity(700);
		homefuelorder1.setSupplyDate("2016/02/03");
		homefuelorder1.setSupplyTime("10:00");
		homefuelorder1.setUrgent(1);

		float price = (float)  (((700*5.23)*0.97)+((700*5.23)*0.97)*0.02);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		invoice1.setPrice((float) ((homefuelorder1.getQuantity()*rates.getMaxHomeFuel()*0.97)+(homefuelorder1.getQuantity()*rates.getMaxHomeFuel()*0.97)*0.02));
		invoice1.setFuelType("HomeFuel");
		invoice1.setUrgent(1);
		invoice1.setInvoiceId(1);
		invoice1.setOrderDate(dateFormat.parse(homefuelorder1.getSupplyDate()));
		invoice1.setQuantity(700);
		invoice1.SetCustomerId(homefuelorder1.getInvitedById());
		invoice1.setTime(homefuelorder1.getSupplyTime());
		
		
		assertEquals(homefuelorder1.getAddressToSupply(),"ort Braude");
		assertEquals(invoice1.getPrice(), price,0.0001);
		assertEquals(invoice1.getCustomerId(),1);
		assertEquals(invoice1.getUrgent(),1);
		assertEquals(invoice1.getQuantity(),700);
		assertEquals(invoice1.getOrderDate(), dateFormat.parse("2016/02/03"));
		assertEquals(invoice1.getTime(), "10:00");

}
}
