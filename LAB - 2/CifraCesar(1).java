import java.util.Scanner;

public class CifraCesar {

    public static void main(String[] args) {

    	Scanner scan = new Scanner(System.in);

        String encrypted = "";

        int key = scan.nextInt();

        String text = scan.nextLine();

        for (int i = 0; i < text.length(); i++) {

        	if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {

                if((int) (text.charAt(i) + key) > 122) {

                    char x = (char) (text.charAt(i) + key);
                    char y = (char) (x - 122);
                    encrypted += (char) (96 + y);

                }
                else{

                    encrypted += (char) (text.charAt(i) + key);
                }
            }
            else{

            	encrypted+=text.charAt(i);
            }
        }

        System.out.println(encrypted.substring(1,encrypted.length()).toUpperCase());
	}
}