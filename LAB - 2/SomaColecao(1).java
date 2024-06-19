import java.util.Scanner;

public class SomaColecao{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();

		int sum = 0;

		while(num != -1){

			sum += num;
			num = scan.nextInt();
		}

		System.out.println(sum);

	}
}