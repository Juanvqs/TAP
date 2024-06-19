import java.util.Scanner;

public class AreaPoligono{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		float x[] = new float[1000005];
		float y[] = new float[1000005];

		int tam = 0;
		float num = scan.nextFloat();

		while(num != -1){

			x[tam] = num;
			num = scan.nextFloat();
			tam++;
		}

		tam  = 0;

		num = scan.nextFloat();

		while(num != -1){

			y[tam] = num;
			tam++;
			num = scan.nextFloat();
		}

		float ans = 0;

		for(int i = 0; i <= tam - 2; i++){

			ans += (x[i + 1] + x[i]) * (y[i + 1] - y[i]);
		}

		ans *= 1.0/2.0;

		System.out.printf("%.4f\n",(double)Math.abs(ans));
	}
}
