import java.util.Scanner;

public class AproximacaoPi{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();

		int x = 2;

		double sum = 3;
		System.out.printf("%.6f",sum);
		System.out.println();

		for(int i = 0; i < num-1; i++){

			if((i%2!=0)){
				sum-=4.0/(x * (x+1) * (x+2));
			}
			else{
				sum+=4.0/(x * (x+1) * (x+2));
			}
			x+=2;
			System.out.printf("%.6f",sum);
			System.out.println();
		}

	}
}