import java.util.Scanner;

public class FolhaPagamento{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);

		double v = scan.nextDouble();
		int h = scan.nextInt();

		double salario = h * v;
		double imposto = (salario * 11)/100;
		double inss = (salario * 8)/100;
		double descontos = imposto + inss;
		double salario_liquido = salario - descontos; 


		System.out.printf("Salario bruto: R$%.2f\n", salario);
		System.out.printf("IR: R$%.2f\n", imposto);
		System.out.printf("INSS: R$%.2f\n", inss);
		System.out.printf("Total de descontos: R$%.2f\n", descontos);
		System.out.printf("Salario liquido: R$%.2f\n", salario_liquido);

	}
}