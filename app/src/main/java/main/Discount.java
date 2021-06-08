package main;

public class Discount {
	private final Identity identity;
	private final int hour;
	private final int min;
	private double discountRate = 0;

	public Discount(Identity identity, String dateTime) throws PoolAccessException {

		this.identity = identity;
		this.hour = InputNormalization.extractHour(dateTime);
		this.min = InputNormalization.extractMin(dateTime);

		checkException();
	}

	public void checkException() throws PoolAccessException {
		if (3 > identity.getAge()) {
			throw new PoolAccessException("Your age is too young.");
		} else if (identity.getAge() > 75) {
			throw new PoolAccessException("Your age doesn't meet the requirements.");
		} else if ((5 > hour || hour > 22) || (hour == 22 && min > 0)) {
			throw new PoolAccessException("Business hours: 05:00-22:00");
		} else {
			queryDiscount(identity, hour);
		}
	}

	private void queryDiscount(Identity identity, int hour) {
		if (identity.isMember()) {
			discountRate = 0.5;
		} else if (identity.isGroup()) {
			discountRate = 0.7;
		} else if (12 > identity.getAge() || identity.getAge() >= 60) {
			discountRate = 0.8;
		} else if (5 <= hour && hour < 7) {
			discountRate = 0.8;
		} else {
			discountRate = 1;
		}
	}

	public double getDiscountRate() {
		return discountRate;
	}
}
