import java.util.Scanner;

public class AproximacaoSeno{

	public static double factorial(double number){
		
	  double fact = 1;

	  for(int i=1;i<=number;i++){

	      fact=fact*i;    
	  }

	  return fact;
    }

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		double a = scan.nextDouble();

		double num = scan.nextDouble();

		double sum = Math.toRadians(a);

		double exp = 3;

		System.out.printf("%.10f",sum);
		System.out.println();

		for(int i = 0; i < num-1; i++){

			if(i%2 == 0){

				sum-=(Math.pow(Math.toRadians(a),exp)/factorial(exp));
			}
			else{

				sum+=(Math.pow(Math.toRadians(a),exp)/factorial(exp));
			}

			exp+=2;

			System.out.printf("%.10f",sum);
			System.out.println();
		}

	}
}