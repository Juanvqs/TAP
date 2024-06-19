import java.util.Scanner;

public class NumeroNeperiano{

	public static int factorial(int number){
		
	  int fact = 1;

	  for(int i=1;i<=number;i++){

	      fact=fact*i;    
	  }

	  return fact;
    }

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();

		double sum = 0;

		for(int i = 0; i < num; i++){

			sum += 1.0/factorial(i);
		}

		System.out.printf("%.6f",sum);
		System.out.println();

	}
}