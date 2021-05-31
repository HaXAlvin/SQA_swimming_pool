package main;
import org.junit.jupiter.api.*;
public class PaymentTest {
    @DisplayName("原始價格測試")
    @Nested
    class MoneyTest{
        Identity identity = new Identity(25,false,false);
        @Test
        public void weekdayTest() throws Throwable {

            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(Payment.weekdayCharge,payment.money);
        }
        @Test
        public void weekendTest() throws Throwable {
            String dateTime = "2021-05-29 週六 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(Payment.weekendCharge,payment.money);
        }
    }
    @DisplayName("折後價格測試")
    @Nested
    class TotalChargeTest{
        @Test
        public void weekendTest() throws Throwable {
            Identity identity = new Identity(25,false,false);
            String dateTime = "2021-05-29 週六 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(250,payment.getTotalCharge());
        }
        @Test
        public void weekdayTest() throws Throwable {
            Identity identity = new Identity(25,false,false);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(200,payment.getTotalCharge());
        }
        @Test
        public void memberTest() throws Throwable {
            Identity identity = new Identity(25,true,false);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(100,payment.getTotalCharge());
        }
        @Test
        public void groupTest() throws Throwable {
            Identity identity = new Identity(25,false,true);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(140,payment.getTotalCharge());
        }
        @Test
        public void ageTest() throws Throwable {
            Identity identity = new Identity(10,false,false);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(160,payment.getTotalCharge());
        }
        @Test
        public void timeTest() throws Throwable {
            Identity identity = new Identity(25,false,false);
            String dateTime = "2021-05-26 週三 06:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(160,payment.getTotalCharge());
        }
    }
    @DisplayName("涵蓋度完整")
    @Nested
    class OnlyForCoverage{
        @Test
        public void printTest() throws Throwable {
            Identity identity = new Identity(25,false,false);
            String dateTime = "2021-05-26 週三 06:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            payment.print();
        }
    }

}