import java.util.Scanner;

public class Media{
	
	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);

		float num_1 = scan.nextFloat();
		float num_2 = scan.nextFloat();
		float num_3 = scan.nextFloat();

		float media = (num_1 + num_2 + num_3)/3;

		System.out.printf("%.2f\n",media);
		
	}
}
