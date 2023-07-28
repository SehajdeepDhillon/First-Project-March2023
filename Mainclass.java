import java.util.Random;

public class Mainclass {
     public static void main(String[] args) {
        System.out.println("Hello Wrld");
        boolean result = Dicegame();
        if (result){
            System.out.println("Congrats you Win!");
        }
        else{
            System.out.println("You loose, Try again");
        }
    }
        public static boolean Dicegame() {
            Random r =  new Random();
            int result = r.nextInt(6);
            result++;
            int comp1 = result;
            Random w =  new Random();
            int result2 = w.nextInt(6);
            result2++;
            int comp2 = result2;
            Random x =  new Random();
            int result3 = x.nextInt(6);
            result3++;
            int player1 = result3;
            Random y =  new Random();
            int result4 = y.nextInt(6);
            result4++;
            int player2 = result4;
           
            int comp_total = comp1+comp2;
            int player_total = player1 + player2;


            if (comp_total>=player_total){
                return false;
            }
            else{
                return true;
            }
               
            }


}



