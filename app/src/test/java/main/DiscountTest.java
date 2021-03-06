package main;

import org.junit.jupiter.api.*;

public class DiscountTest {

	@DisplayName("不同年紀的折扣")
	@Nested
	class DifferentAges {
		String dateTime = "2021-05-26 週三 14:30:00";

		@Test
		void testAgeHasDiscount() throws Throwable {
			Identity identity = new Identity(10, false, false);
			Discount discount = new Discount(identity, dateTime);
			Assertions.assertEquals(0.8, discount.getDiscountRate());
		}

		@Test
		 void testAgeLessThan() {
			Identity identity = new Identity(2, false, true);
			try {
				new Discount(identity, dateTime);
			} catch (Throwable exception) {
				Assertions.assertEquals("Your age is too young.", exception.getMessage());
			}
		}

		@Test
		 void testAgeMoreThan() {
			Identity identity = new Identity(76, false, true);
			try {
				new Discount(identity, dateTime);
			} catch (Throwable exception) {
				Assertions.assertEquals("Your age doesn't meet the requirements.", exception.getMessage());
			}
		}
	}

	@DisplayName("營業與非營業時間")
	@Nested
	class DifferentBusinessHours {
		Identity identity = new Identity(25, false, false);
		@Test
		 void testEarlyBirdBusiness() throws Throwable {
			Discount discount = new Discount(identity, "2021-05-26 週三 06:30:00");
			Assertions.assertEquals(0.8, discount.getDiscountRate());
		}

		@Test
		 void testHaveBusiness() throws Throwable {
			Discount discount = new Discount(identity, "2021-05-26 週三 10:30:00");
			Assertions.assertEquals(1, discount.getDiscountRate());
		}

		@Test
		 void testEarlyBusiness() {
			try {
				new Discount(identity, "2021-05-26 週三 04:30:00");
			} catch (Throwable exception) {
				Assertions.assertEquals("Business hours: 05:00-22:00", exception.getMessage());
			}

		}
		@Test
		void testLateBusiness() {
			try {
				new Discount(identity, "2021-05-26 週三 23:30:00");
			} catch (Throwable exception) {
				Assertions.assertEquals("Business hours: 05:00-22:00", exception.getMessage());
			}

		}
		@Test
		void testJustOutBusiness() {
			try {
				new Discount(identity, "2021-05-26 週三 22:01:00");
			} catch (Throwable exception) {
				Assertions.assertEquals("Business hours: 05:00-22:00", exception.getMessage());
			}

		}
	}

	@DisplayName("身份折扣")
	@Nested
	class DifferentIdentity {
		String dateTime = "2021-05-26 週三 14:30:00";
		@Test
		 void testIsMember() throws Throwable{
			Identity identity = new Identity(25, true, false);
			Discount discount = new Discount(identity, dateTime);
			Assertions.assertEquals(0.5, discount.getDiscountRate());
		}
		@Test
		 void testIsGroup() throws Throwable{
			Identity identity = new Identity(25, false, true);
			Discount discount = new Discount(identity, dateTime);
			Assertions.assertEquals(0.7, discount.getDiscountRate());
		}
		@Test
		 void testBothMemberAndGroup() throws Throwable{
			Identity identity = new Identity(25, true, true);
			Discount discount = new Discount(identity, dateTime);
			Assertions.assertEquals(0.5, discount.getDiscountRate());
		}
	}
}
