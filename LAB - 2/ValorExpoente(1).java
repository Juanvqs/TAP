import java.util.Scanner;

public class ValorExpoente{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		double num = scan.nextInt();

		int sum = 0;

		int v = 0;

		int exp = 1;


		while(sum <= num){

			sum+=Math.pow(2,exp);
			exp++;
			v++;

		}

		System.out.println(v);

	}
}