import java.util.Scanner;

public class MediaColecao{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		float sum = 0;

		float div = 0;

		int num = scan.nextInt();

		while(num != -1){

			sum += num;
			div++;
			num = scan.nextInt();
		}

		float ans = sum/div;

		System.out.printf("%.2f\n",ans);

	}
}
