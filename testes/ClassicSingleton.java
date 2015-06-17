public final class ClassicSingleton extends AbstractTeste1 implements InterfaceTeste, InterfaceTeste2 {
	public final static ClassicSingleton instance = getInstance();
	public final static String teste = "Teste";
	public final static long valLong= 544213139;
	public final static int valInt = 123124;
	public final static double valDouble= 54.0224;
	public final static double notANumber = Double.POSITIVE_INFINITY/Double.POSITIVE_INFINITY;
	public final static double infP = Double.POSITIVE_INFINITY;
	public final static double infN = -Double.POSITIVE_INFINITY;
	public final static Exception e = new Exception("Deu Ruim.!");
	public final static boolean[][] boliSample = {{ false, false }, { true, true } };

	protected ClassicSingleton() { }

	public static ClassicSingleton getInstance() {
		if (instance == null) {
			return new ClassicSingleton();
		}
		return instance;
	}

	public int div(int a, int b) {
		return 0;
	}

	public int soma(int a, int b){
		int resultado = 0;
		resultado = a+b;
		return resultado;
	}

	public int soma2(int a, int b, int c) {
		int resultado = 0;
		resultado = a + b + c;

		return resultado;
	}

	public static void main(String args[]) {
		ClassicSingleton var = new ClassicSingleton();
		System.out.println("Main: soma1: " + var.soma(1,2) + "soma2: " + var.soma2(1,2,3));
	}
}

class AbstractTeste1 {
	public Integer teste(Object b) {
		return (Integer)b;
	}
}

interface SuperInterface {
	public int div(int a, int b);
}

interface InterfaceTeste extends SuperInterface {
	public int soma(int a, int b);
	public int div(int a, int b);
}

interface InterfaceTeste2 {
	int soma2(int a, int b, int c);
}