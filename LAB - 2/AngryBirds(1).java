import java.util.Scanner;

public class AngryBirds{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		float v = scan.nextFloat();
		float a = scan.nextFloat();
		float d = scan.nextFloat();

		double ans = (Math.pow(v,2) * Math.sin(2*Math.toRadians(a)))/9.8;


		if(ans-d < 0.1 && ans-d > -0.1){

			System.out.println("1");
		}
		else{
			System.out.println("0");
		}

	}
}
