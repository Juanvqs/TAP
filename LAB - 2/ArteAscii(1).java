import java.util.Scanner;


public class ArteAscii{

	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();

		for(int i = 0; i < num; i++){

			for(int j = 0; j < num-i; j++){

				System.out.print("*");

			}
			System.out.println();

		}
		for(int i = 0; i < num; i++){

			for(int j = 0; j <= i; j++){

				System.out.print("*");

			}
			System.out.println();

		}
		
	}
}