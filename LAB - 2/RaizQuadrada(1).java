import java.util.Scanner;

public class RaizQuadrada{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();

		double raiz = Math.sqrt(num);

		System.out.printf("%.4f\n",raiz);
	}
}