
public class Operations {
	public static double fatorial(double n) {
		double value = n;
		for(int i = (int)n-1; i > 0; i--) {
			value = value * (i);
		}
		return value;
	}
	public static double exp_E(double n) {
		return Math.exp(n);
	}
	public static double sqrt(double rfs) {
		return Math.sqrt(rfs);
	}
	public static double sqrt_3(double n) {
		return Math.cbrt(n);
	}
	public static double porcento(double n) {
		return n/100;
	}
	public static double ao_quadrado(double n) {
		return Math.pow(n,2);
	}
	public static double ao_cubo(double n) {
		return Math.pow(n,3);
	}
	public static double na_n(double n,double m) {
		return Math.pow(n,m);
	}
	public static double pi() {
		return Math.PI;
	}
	//fazer clear e parenteses, ( e )
	public static void main( String[] args ) {
		Operations operation = new Operations();
//		System.out.println(operation.fatorial(5));
//		System.out.println(operation.exp_E(2));
//		System.out.println(operation.sqrt_2(25));
//		System.out.println(operation.sqrt_3(-27));
//		System.out.println(operation.porcento(25));
//		System.out.println(operation.ao_quadrado(4));
//		System.out.println(operation.ao_cubo(2));
//		System.out.println(operation.na_n(2,10));
	}
	
}
