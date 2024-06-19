import java.util.Scanner;

public class OperacoesInteiros{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int vector[] = new int[100005];

        while(true){

            int tam = 0;
            int odd = 0;
            int even = 0;
            int sum = 0;
            float average = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int num = scan.nextInt();
            
            if(num == -1){
                break;
            }

            while(num != -1){

                if(num > max){
                    max = num;
                }
                if(num < min){
                    min = num;
                }
                if((num & 1) != 0){
                    odd++;
                }
                else{
                    even++;
                }
                
                vector[tam] = num;
                sum += num;
                tam++;

                num = scan.nextInt();
            }


            average = (float)sum/(tam);
            
            System.out.println(tam);
            System.out.println(even);
            System.out.println(odd);
            System.out.println(sum);
            System.out.printf("%.2f\n",average);
            System.out.println(max);
            System.out.println(min);

        }
    }
}