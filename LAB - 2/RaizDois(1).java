import java.util.Scanner;

public class RaizDois{

	public static double raiz(double num){

		if(num == 0){
			return 1.0;
		}

		return 1/(2+raiz(num-1));
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		double num = scan.nextDouble();

		for(int i = 1; i <= num; i++){

			System.out.printf("%.14f",1 + raiz(i));
			System.out.println();

		}
	}

}