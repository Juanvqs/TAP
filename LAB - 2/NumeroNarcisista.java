import java.util.Scanner;

public class NumeroNarcisista{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		int num = scan.nextInt();

		int v[] = new int[11];

		int tmp = num;
		
		double ans = 0;

		int d = 0;


		while(tmp > 0){

			v[d++] = tmp%10;
			tmp/=10;
		}

		for (int i = 0; i < d ; i ++) {

			ans += Math.pow(v[i],d);
			
		}

		if(ans == num){
			System.out.println("SIM");
		}
		else{
			System.out.println("NAO");
		}

	}
}