import java.util.Scanner;

public class Desconto{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		float price = scan.nextFloat();

		float discount = price*5/100;

		if(price < 200){
			System.out.println(price);
		}
		else{
			System.out.printf("%.2f\n",price - discount);
		}

	}
}
