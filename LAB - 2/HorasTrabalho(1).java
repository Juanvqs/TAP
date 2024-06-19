import java.util.Scanner;

public class HorasTrabalho{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int grid[][] = new int[100005][8];

        int num = 1;

        int tam = 0;

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

        for(int i = 0; i < tam; i++){

            int sum = 0;

            for (int j = 0; j < 7; j++) {
                
                sum += grid[i][j];
            }

            System.out.println(sum);
        }
    }
}