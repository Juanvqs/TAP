import java.util.Scanner;

public class TimeFutebol{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int goal[] = new int[100005];
        int opposing_goal[] = new int[100005];

        int num = scan.nextInt();

        int tam = 0;
        int v = 0;
        int draw = 0;
        int d = 0;

        while(num != -1){

            goal[tam++] = num;

            num = scan.nextInt();
        }

        tam = 0;

        num = scan.nextInt();

        while(num != -1){

            opposing_goal[tam++] = num;

            num = scan.nextInt();
        }



        for(int i = 0; i < tam; i++){

            if(goal[i] == opposing_goal[i]){

                draw++;
            }
            else if(goal[i] > opposing_goal[i]){

                v++;
            }
            else{
                d++;
            }

        }

        System.out.printf("%d %d %d", v, draw, d);
        System.out.println();
        
    }

}