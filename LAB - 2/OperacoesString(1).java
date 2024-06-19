import java.util.Scanner;

public class OperacoesString{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		String s = scan.nextLine();

		int v = 0;

		System.out.println(s.length());
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(s.length()-1));
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.replace('a','e'));

		for(int i = 0; i < s.length(); i++){

			if((i & 1 ) == 0){
				System.out.print(s.charAt(i));
			}
			if(s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O' || s.charAt(i) == 'u' || s.charAt(i) == 'U'){
				v++;
			}
		}
		System.out.println();
		System.out.println(v);
	}
}