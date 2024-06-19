import java.util.Scanner;

public class PorcentagemAcerto{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int r[] = new int[1000005];
		int g[] = new int[1000005];

		int num = scan.nextInt();

		int tam = 0;

		double a = 0;

		while(num != -1){

			r[tam++] = num;
			num = scan.nextInt();
		}

		tam = 0;

		num = scan.nextInt();

		while(num != -1){

			g[tam++] = num;
			num = scan.nextInt();
		}

		for(int i = 0; i < tam; i++){

			if(r[i] == g[i]){
				a++;
			}
		}

		double ans = (a/tam)*100;

		System.out.printf("%.2f",ans);
		System.out.println();

	}
}