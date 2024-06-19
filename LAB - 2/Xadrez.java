import java.util.Scanner;

public class Xadrez{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();

		for(int i = 0; i < num; ++i){

			if((i&1) != 0){
				System.out.print(" ");

			}
			for(int j = 0; j < num; ++j){
				System.out.print("* ");
			}
			System.out.println();
		}

	}
}