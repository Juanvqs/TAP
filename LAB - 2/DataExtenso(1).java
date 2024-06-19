import java.util.Scanner;

public class DataExtenso{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		String s = scan.next();

		int dia = Integer.parseInt(s.substring(0,2));
		int mes = Integer.parseInt(s.substring(2,4));
		int ano = Integer.parseInt(s.substring(4,8));


		switch(mes){
			case 1:
				System.out.println(dia + " de janeiro" + " de " + ano);
				break;
			case 2:
				System.out.println(dia + " de fevereiro" + " de " + ano);
				break;
			case 3:
				System.out.println(dia + " de março" + " de " + ano);
				break;
			case 4:
				System.out.println(dia + " de abril" + " de " + ano);
				break;
			case 5:
				System.out.println(dia + " de maio" + " de " + ano);
				break;
			case 6:
				System.out.println(dia + " de junho" + " de " + ano);
				break;
			case 7:
				System.out.println(dia + " de julho" + " de " + ano);
				break;
			case 8:
				System.out.println(dia + " de agosto" + " de " + ano);
				break;
			case 9:
				System.out.println(dia + " de setembro" + " de " + ano);
				break;
			case 10:
				System.out.println(dia + " de outubro" + " de " + ano);
				break;
			case 11:
				System.out.println(dia + " de novembro" + " de " + ano);
				break;
			case 12:
				System.out.println(dia + " de dezembro" + " de " + ano);
				break;

		}
	}
}