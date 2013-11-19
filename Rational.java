public class Rational {
    
    int numerator; int denominator;

    public Rational(){  numerator = 0; denominator = 1;  }
    
    public Rational(int x, int y){ 
	if (y == 0){ 
	    System.out.println("Cannot Divide by 0"); 
	    x = 0; y = 1; }
	numerator = x; denominator = y; }
    
    public String toString() {
	return numerator + "/" + denominator; }
    
    public double floatValue() {
	return (double)((float) numerator / denominator); }
    
    public void multiply(Rational x) {
	numerator *= x.numerator;
	denominator *= x.denominator; }
    
    public void divide(Rational x) {
	numerator *= x.denominator;
	denominator *= x.numerator; }
    
    public void add(Rational x) {
	int higher; int totimes; int same; double factor;
	if (x.denominator > denominator) {	    
	    higher = x.denominator; totimes = x.numerator;
	    same = numerator;
	    factor = (double) higher / denominator; }
	else {
	    higher = denominator; totimes = numerator;
	    same = x.numerator;
	    factor = (double) higher / x.denominator; }	
	totimes = (int)(totimes *= factor);
	numerator = same + totimes;
	denominator = higher; }
    public void subtract(Rational x) {
	int higher; int totimes; int same; double factor;
	if (x.denominator > denominator) {	    
	    higher = x.denominator; totimes = x.numerator;
	    same = numerator;
	    factor = (double) higher / denominator; }
	else {
	    higher = denominator; totimes = numerator;
	    same = x.numerator;
	    factor = (double) higher / x.denominator; }	
	totimes = (int)(totimes *= factor);
	numerator = same - totimes;
	denominator = higher; }
    public int gcd(){
	int counter = 1;
	int gcd = 1;
	while (counter <= Math.min( numerator , denominator )){
	    if (numerator % counter == 0 && denominator % counter == 0){
		gcd = counter;
	    }
	    counter += 1;
	}
	return gcd;
    }
    public void reduce(){
	int divide = gcd();
	if (gcd() != 1)
	    numerator /= divide; denominator /= divide; }
    public static int gcd(int a, int b){
	int counter = 1;
	int gcd = 1;
	while (counter <= Math.min( a , b )){
		if (a % counter == 0 && b % counter == 0){
		    gcd = counter;
		}
		counter += 1;
	    }
	return gcd; }
    public int compareTo(Rational x){
	x.reduce(); reduce();
	if (x.numerator == numerator && x.denominator == denominator) 
	    return 0;
	else if (floatValue() > x.floatValue())
	    return 1;
	else 
	    return -1; }
    public static void main (String [] args) {
	Rational me = new Rational(1,2);
	Rational you = new Rational(2,4);
	System.out.println(you);
	System.out.println(me.floatValue());
	me.add(you);
	System.out.println(me);
	me.multiply(you);
	System.out.println(me);
	you.reduce();
	System.out.println(you);
	System.out.println(me.compareTo(you));
    }
}
