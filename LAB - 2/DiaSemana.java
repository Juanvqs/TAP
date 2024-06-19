import java.util.Scanner;

public class DiaSemana{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int grid[][] = new int[100005][8];

        int dias[] = {1,2,3,4,5,6,7};

        int diaM[] = new int[8];

        int num = 1;

        int tam = 0;

        int k = 0;

        int sumA = 0;

        while(num != -1){

            for (int i = 0; i < 7 && num != -1 ; i++){
                num = scan.nextInt();

                if(num != -1){

                    grid[tam][i] = num;
                }
            }   

            tam++;

        }

        tam--;



        for(int i = 0; i < 7; i++){

            int sum = 0;

            for (int j = 0; j < tam; j++) {
                
                sum += grid[j][i];
            }

            if(sum > sumA){

                sumA = sum;
                diaM[k] = dias[i];

            }
            else if(sum == sumA){
                k++;
                diaM[k] = dias[i];
            }
        }

        for (int i = 0; i <= k ; i++) {

            System.out.println(diaM[i]);   
        }
    }
}