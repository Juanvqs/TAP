import java.util.Scanner;

public class VolumeCombustivel{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		float h = scan.nextFloat();
		float c = scan.nextFloat();
		float r = scan.nextFloat();
		
		if(h < 0 || c < 0 || r < 0){

			System.out.println("-1");
		}
		else if(c < r){
			double v = (Math.PI* Math.pow(c,2) * (3 * r - c))*1/3;

			System.out.printf("%.3f",v);
			System.out.println();
		}
		else if(c < h - r){
			double v = (((Math.PI * Math.pow(r,3))*2/3)) + (Math.PI * Math.pow(r,2) * (c - r));

			System.out.printf("%.3f",v);
			System.out.println();
		}
		else if(c <= h){
			double v =((Math.PI * Math.pow(r,3))*4/3) + (Math.PI * Math.pow(r,2) * (h - 2 * r)) - (((Math.PI * Math.pow(h-c,2) * ((3 * r - h + c)))*1/3));

			System.out.printf("%.3f",v);
			System.out.println();
		}
		else{
			System.out.println("-1");
		}

	}
}