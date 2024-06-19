import java.util.Scanner;

public class Fahrenheit{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double c = scan.nextInt();

		double f = (9 * c)/5 + 32;

		System.out.printf("%.1f\n",f);
		
	}
}
