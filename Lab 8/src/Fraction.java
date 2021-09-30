public class Fraction {

	private int numerator, denominator;
	
	public Fraction(int n, int d) {
		int gcd = GCD(numerator, denominator);
		if (d == 0) {
			throw new ArithmeticException("Denominator d can NOT be zero");
		}
		numerator = n;
		denominator = d;
	}
	
	public int getNum() {
		return numerator;
	}
	
	public int getDenom() {
		return denominator;
	}
	
	public void setNum(int n) {
		numerator = n;
	}
	
	public void setDenum(int d) {
		if(d == 0) {
			throw new ArithmeticException("Denominator d can NOT be zero");
		}
		denominator = d;
	}
	
	public Fraction add(Fraction a) {
		// (a*d+b*c)
		int new_Num = (numerator * a.denominator) + (denominator * a.numerator);
		// b*d
		int new_Denom = denominator * a.denominator;
		
		
		return new Fraction(new_Num, new_Denom);
	}
	
	public boolean equals(Fraction a) {
		if (numerator == a.numerator && denominator == a.denominator) {
			return (numerator == a.numerator && denominator == a.denominator);
		}
		else if (numerator * a.denominator == denominator * a.numerator) {
			return (numerator * a.denominator == denominator * a.numerator);
		}
		return false;
	}
	
	public String toString() {
		StringBuilder fraction = new StringBuilder();
		
		int gcd = GCD(numerator, denominator);
		fraction.append(numerator/gcd)
				.append("/")
				.append(denominator/gcd);
		
		return fraction.toString();
	}
	
	public int GCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(10, 10);
		System.out.println("f1 is: " + f1); // 1/2
		
		Fraction f2 = new Fraction(5, 8);
		System.out.println("Is f1 equal to f2?: " + f1.equals(f2)); // does 1/2 equal 5/8? FALSE
		
		f1.add(f2);
		f1.setDenum(8);
		
		System.out.println("new f1 denom is: " + f1.getDenom());
		System.out.println("new f1 num is: " + f1.getNum());
	}
}
