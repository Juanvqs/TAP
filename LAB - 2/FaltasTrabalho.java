import java.util.Scanner;

public class FaltasTrabalho{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int dias[] = new int[100005];

        int num = scan.nextInt();

        int tam = 0;
        double segunda = 0;
        double terca = 0;
        double quarta = 0;
        double quinta = 0;
        double sexta = 0;
        double sabado = 0;

        while(num != -1){

            dias[tam++] = num;

            num = scan.nextInt();
        }

        for(int i = 0; i < tam; i++){

            if(dias[i] == 2){

                segunda++;
            }
            else if(dias[i] == 3){

                terca++;
            }
            else if(dias[i] == 4){

                quarta++;
            }
            else if(dias[i] == 5){

                quinta++;
            }
            else if(dias[i] == 6){

                sexta++;
            }
            else{

                sabado++;

            }

                
        }
        segunda = (100*segunda)/tam;
        terca = (100*terca)/tam;
        quarta = (100*quarta)/tam;
        quinta = (100*quinta)/tam;
        sexta = (100*sexta)/tam;
        sabado = (100*sabado)/tam;


        System.out.printf("%.1f %.1f %.1f %.1f %.1f %.1f", segunda, terca, quarta, quinta, sexta, sabado);
        System.out.println();


    }

}