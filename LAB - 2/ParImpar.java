import java.util.Scanner;

public class ParImpar{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();


		while(num != -1){

			if((num & 1) == 0){
				System.out.println("PAR");
			}
			else{
				System.out.println("IMPAR");
			}

			num = scan.nextInt();
		}

	}
}