package com.lukman;

import com.lukman.Item.ItemCategories;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;

public class SolutionTest {
	
	private static final String USER_NAME = "Superman";
	
	@Test
	public void new_user_with_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("945.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void new_user_without_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("945.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void new_user_with_combine_item() throws Exception {
		final BigDecimal expected = new BigDecimal("1885.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 4", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void employee_user_with_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("663.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, true, false));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void employee_user_without_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("945.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, true, false));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void employee_user_with_combine_item() throws Exception {
		final BigDecimal expected = new BigDecimal("1603.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, true, false));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void affiliate_user_with_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("851.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, false, true));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void affiliate_user_without_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("945.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, false, true));
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void affiliate_user_with_combine_item() throws Exception {
		final BigDecimal expected = new BigDecimal("1791.00");
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, false, true));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 4", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void loyal_user_with_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("895.50");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -3);
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, cal.getTime(), false, false));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void loyal_user_without_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("945.00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -3);
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, cal.getTime(), false, false));
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 4", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void loyal_user_with_combine_item() throws Exception {
		final BigDecimal expected = new BigDecimal("1791.00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -3);
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, cal.getTime(), false, true));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 4", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void loyal_affiliate_user_with_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("851.00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -3);
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, cal.getTime(), false, true));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void loyal_affiliate_user_without_item_discount() throws Exception {
		final BigDecimal expected = new BigDecimal("945.00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -3);
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, cal.getTime(), false, true));
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 4", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}
	
	@Test
	public void loyal_affiliate_user_with_combine_item() throws Exception {
		final BigDecimal expected = new BigDecimal("1791.00");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -3);
		Solution3 cart = new Solution3(User.newInstance(USER_NAME, cal.getTime(), false, true));
		cart.addToCart(Item.newInstance("SANDAL 1", ItemCategories.TEXTILE, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 2", ItemCategories.FRESH, new BigDecimal(30)), 3);
		cart.addToCart(Item.newInstance("SANDAL 3", ItemCategories.GROCERIES, new BigDecimal(100)), 9);
		cart.addToCart(Item.newInstance("SANDAL 4", ItemCategories.GROCERIES, new BigDecimal(30)), 3);
		Assert.assertEquals(expected, cart.getPayableAmount());
	}

}
