package fundamentals;

public class Rational{

	private final long numerator;
	private final long denominatior;

	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominatior = denominator / gcd;
	}

	private static long gcd(long p, long q) {
		if (q == 0) {
			return p;
		}
		long r = p % q;
		return gcd(q, r);
	}

	public Rational plus(Rational that) {
		return new Rational(this.numerator * that.denominatior + this.denominatior * that.numerator,
				this.denominatior * that.denominatior);
	}

	public Rational minus(Rational that) {
		return new Rational(this.numerator * that.denominatior - this.denominatior * that.numerator,
				this.denominatior * that.denominatior);
	}

	public Rational times(Rational that) {
		return new Rational(this.numerator * that.numerator, this.denominatior * that.denominatior);
	}

	public Rational dividedBy(Rational that) {
		return new Rational(this.numerator * that.denominatior, this.denominatior * that.numerator);
	}

	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that instanceof Rational) {
			Rational temp = (Rational) that;
			return this.numerator == temp.numerator && this.denominatior == temp.denominatior;
		}
		return false;
	}

	public String toString() {
		return String.format("%d / %d", numerator, denominatior);
	}

}
