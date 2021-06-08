package main;
import org.junit.jupiter.api.*;
public class PaymentTest {
    @DisplayName("原始價格測試")
    @Nested
    class MoneyTest{
        Identity identity = new Identity(25,false,false);
        @Test
         void weekdayTest() throws Throwable {

            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(Payment.weekdayCharge,payment.getMoney());
        }
        @Test
         void weekendTest() throws Throwable {
            String dateTime = "2021-05-29 週六 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(Payment.weekendCharge,payment.getMoney());
        }
    }
    @DisplayName("折後價格測試")
    @Nested
    class TotalChargeTest{
        @Test
         void weekendTest() throws Throwable {
            Identity identity = new Identity(25,false,false);
            String dateTime = "2021-05-29 週六 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(250,payment.getTotalCharge());
        }
        @Test
         void weekdayTest() throws Throwable {
            Identity identity = new Identity(25,false,false);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(200,payment.getTotalCharge());
        }
        @Test
         void memberTest() throws Throwable {
            Identity identity = new Identity(25,true,false);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(100,payment.getTotalCharge());
        }
        @Test
         void groupTest() throws Throwable {
            Identity identity = new Identity(25,false,true);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(140,payment.getTotalCharge());
        }
        @Test
         void ageTest() throws Throwable {
            Identity identity = new Identity(10,false,false);
            String dateTime = "2021-05-26 週三 14:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            Assertions.assertEquals(160,payment.getTotalCharge());
        }
        @Test
         void timeTest() throws Throwable {
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
         void printTest() throws Throwable {
            Identity identity = new Identity(25,false,false);
            String dateTime = "2021-05-26 週三 06:30:00";
            Discount discount = new Discount(identity,dateTime);
            Payment payment = new Payment(discount,dateTime);
            payment.print();
        }
    }

}
