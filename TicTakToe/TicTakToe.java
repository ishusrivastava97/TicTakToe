import java.util.Random;
import java.util.*;
import java.util.List;
import java.util.Arrays;
class TicTakToe {
    static ArrayList<Integer> playerpositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpupositions = new ArrayList<Integer>();
    public static void main( String args[] ) {
     char ch [][] ={{' ','|',' ','|',' ',' '},
                   {'-','+','-','+','-'},
                   {' ','|',' ','|',' '},
                   {'-','+','-','+','-'},
                    {' ','|',' ','|',' '}};
                    print2D(ch);
while (true) {


    Scanner sc = new Scanner (System.in);
    System.out.println("enter position from 1-9");
    int playerpos = sc.nextInt();
    while(playerpositions.contains(playerpos) || cpupositions.contains(playerpos))
    {
        System.out.println("position taken! input correct position");
        playerpos=sc.nextInt();
    }


    placepice(ch,playerpos,"player");
    String result = checkwinner();
    if (result.length()>0) {
        System.out.println(result);
        break;

    }

    Random rand = new Random();
    int cpupos = rand.nextInt(9) +1;
    while(playerpositions.contains(cpupos) || cpupositions.contains(cpupos))
    {
        System.out.println("position taken input correct position");
         cpupos = rand.nextInt(9) +1;
    }
    placepice(ch,cpupos,"cpu");
    print2D(ch);
    /*
    String chec= checkwinner();
    if (chec.length()>0) {
        System.out.println(chec);
        break;
    }

print2D(ch);
 chec= checkwinner();
 if (chec.length()>0) {
     System.out.println(chec);
     break;

 }
*/
result = checkwinner();
if (result.length()>0) {
    System.out.println(result);
    break;

}

}

    }
    public static void print2D(char mat[][])
    {

        for (int i = 0; i < mat.length; i++)
{

            for (int j = 0; j < mat[i].length; j++){
                System.out.print(mat[i][j] );
            }
                System.out.println();
    }

}
public static void placepice(char ch [][], int pos, String user ) {
    char symbol =' ';
    if (user.equals("player")) {
        symbol='X';
        playerpositions.add(pos);
    }
    else if (user.equals("cpu"))
    {
        symbol='O';
        cpupositions.add(pos);
    }
    switch (pos) {
        case 1:
        ch[0][0]=symbol;
        break;
        case 2:
        ch[0][2]=symbol;
        break;
        case 3:
        ch[0][4]=symbol;
        break;
        case 4:
        ch[2][0]=symbol;
        break;
        case 5:
        ch[2][2]=symbol;
        break;
        case 6:
        ch[2][4]=symbol;
        break;
        case 7:
        ch[4][0]=symbol;
        break;
        case 8:
        ch[4][2]=symbol;
        break;
        case 9:
        ch[4][4]=symbol;
        break;
        default:
            break;
    }
}
public static String checkwinner() {
    List toprow = Arrays.asList(1,2,3);
    List midrow = Arrays.asList(4,5,6);
    List bottomrow = Arrays.asList(7,8,9);
    List leftcol = Arrays.asList(1,4,7);
    List midcol = Arrays.asList(2,5,8);
    List rightcol = Arrays.asList(3,6,9);
    List cross1 = Arrays.asList(1,5,9);
    List cross2 = Arrays.asList(3,5,7);

    List<List> winning = new ArrayList<List>();
            winning.add(toprow);
            winning.add(midrow);
            winning.add(bottomrow);
            winning.add(leftcol);
            winning.add(midcol);
            winning.add(rightcol);
            winning.add(cross1);
            winning.add(cross2);
               for (List l : winning ) {
                   if (playerpositions.containsAll(l)) {
                       return "congratulations";
                   }
                   else if (cpupositions.containsAll(l)) {
                       return "cpu wins sorry try again :(";
                   }
                   else if (playerpositions.size() + cpupositions.size() == 9 ) {
                       return "TIE";


                   }
               }
               return "";
}
}
