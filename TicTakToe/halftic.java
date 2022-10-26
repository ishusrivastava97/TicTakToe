import java.util.Random;
import java.util.*;
class halftic
{

        public static void main( String args[] ) {
         char ch [][] ={{' ','|',' ','|',' ',' '},
                       {'-','+','-','+','-'},
                       {' ','|',' ','|',' '},
                       {'-','+','-','+','-'},
                        {' ','|',' ','|',' '}};

        Scanner sc = new Scanner (System.in);
        System.out.println("enter position from 1-9");
        int playerpos = sc.nextInt();



        placepice(ch,playerpos,"player");
        Random rand = new Random();
        int cpupos = rand.nextInt(9) +1;
        placepice(ch,cpupos,"cpu");

    print2D(ch);

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
        }
        else if (user.equals("cpu"))
        {
            symbol='O';
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
    }
