import java.util.Scanner;

public class TanqueCombustivel{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		float r = scan.nextFloat();
		float h = scan.nextFloat();
		float o = scan.nextFloat();

		double hubcap = Math.PI/3 * Math.pow(h,2) * (3*r - h);

		if(o == 1){
			System.out.printf("%.4f\n",hubcap);
		}
		else{
			double volume = (Math.PI * Math.pow(r,3)*4/3) - hubcap;

			System.out.printf("%.4f\n",volume);
		}

	}
}