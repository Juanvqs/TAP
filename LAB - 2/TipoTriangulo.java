import java.util.Scanner;

public class TipoTriangulo{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		float a = scan.nextFloat();
		float b = scan.nextFloat();
		float c = scan.nextFloat();

		if(a < 0 || b < 0 || c < 0 || a + b <= c || a + c <= b || c + b <= a){

			System.out.println("invalido");
		}
		else{
			if(a == b && c == b){
				System.out.println("equilatero");
			}
			else if(a != b && a != c && b != c){
				System.out.println("escaleno");
			}
			else{
				System.out.println("isosceles");
			}
		}
	}
}