import java.util.Scanner;

public class Mediana{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int vector[] = new int[100005];

        int num = scan.nextInt();

        int tam = 0;

        while(num != -1){

            vector[tam++] = num;

            num = scan.nextInt();
        }
        if((tam&1) == 0){

            double ans  = (vector[(tam-1)/2]+vector[((tam-1)/2)+1])/2.0;
            System.out.printf("%.1f",ans);
            System.out.println();
        }
        else{
            double ans  = vector[(tam-1)/2];
            System.out.printf("%.1f",ans);
            System.out.println();
        }
    }

}