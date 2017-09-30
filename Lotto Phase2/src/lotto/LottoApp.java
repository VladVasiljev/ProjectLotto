/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/*
 * @author Vladislavs Vasiljevs
 * @author Carl Moylan
 * @author Rafal Konarzewski
 */
public class LottoApp {

    public static void main(String[] args) {

        int userNums1;//V.V user number 1        
        int userNums2;//V.V user number 2       
        int userNums3;//V.V user number 3        
        int userNums4;//V.V user number 4        
        int userNums5;//V.V user number 5        
        int[] lottoNums; //V.V 1D array with 5 indexs randomly generated numbers
        int[] lottoPlusOneNums; //V.V 1D array with 5 indexs randomly generated numbers
        int[] lottoPlusTwoNums; //V.V 1D array with 5 indexs randomly generated numbers
        String gameType;//V.V Variable to store the gameType for each line of numbers     

        //V.V Declaring and creating ArrayList called objectLines this ArrayList stores userNums1/5 and gameType of each line 
        ArrayList<Line> objectLines = new ArrayList<>();

        //V.V Declaring and creating object LottoNums
        LottoNums myLottoNums = new LottoNums();

        //V.V Generates the random numbers
        myLottoNums.lottoNums();
        myLottoNums.lottoPlusOneNums();
        myLottoNums.lottoPlusTwoNums();

        //V.V Getting genereated number from LottoNums class
        lottoNums = myLottoNums.getLottoNums();
        lottoPlusOneNums = myLottoNums.getLottoPlusOneNums();
        lottoPlusTwoNums = myLottoNums.getLottoPlusTwoNums();

        //V.V Declaring and creating an object, which send, the lotto numbers + ArrayList called lines to class Lotto
        Lotto myLotto = new Lotto(lottoNums, lottoPlusOneNums, lottoPlusTwoNums, objectLines);

        //V.V Displaying Random numbers from all three games
        System.out.println(Arrays.toString(lottoNums));
        System.out.println(Arrays.toString(lottoPlusOneNums));
        System.out.println(Arrays.toString(lottoPlusTwoNums));

        /*V.V for loop which loops 3 times, to allow us to create a Array of [3], 
        * which means the user will be able to enter 5 numbers 3 times, which will equal to 15 numbers,
        * also the user will need to enter gameType 3 times.
         */
        for (int i = 0; i < 3; i++) {

            Line eachLine = new Line();//V.V declaring and creating object called eachLine
            do {//C.M. Start of Do/While statement for userNums1 input
                userNums1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number 1"));//V.V UserNum1 = number 1, input from user
            } while (userNums1 < 1 || userNums1 > 40);//C.M. Validating user integer input and allowing it to be re-entered for userNums1            
            do {//C.M. Start of Do/While statement for userNums2 input
                userNums2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number 2"));//V.V UserNum2 = number 2, input from user
            } while (userNums2 < 1 || userNums2 > 40);//C.M. Validating user integer input and allowing it to be re-entered for userNums2            
            do {//C.M. Start of Do/While statement for userNums3 input
                userNums3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number 3"));//V.V UserNum3 = number 3, input from user
            } while (userNums3 < 1 || userNums3 > 40);//C.M. Validating user integer input and allowing it to be re-entered for userNums3            
            do {//C.M. Start of Do/While statement for userNums4 input
                userNums4 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number 4"));//V.V UserNum4 = number 4, input from user
            } while (userNums4 < 1 || userNums4 > 40);//C.M. Validating user integer input and allowing it to be re-entered for userNums4            
            do {//C.M. Start of Do/While statement for userNums5 input
                userNums5 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number 5"));//V.V UserNum5 = number 5, input from user
            } while (userNums5 < 1 || userNums5 > 40);//C.M. Validating user integer input and allowing it to be re-entered for userNums5 
            do{
            gameType = JOptionPane.showInputDialog(null, "What game type would you like to compare your numbers," + "\n" + "Lotto" + "\n" + "Plus1" + "\n" + "Plus2");//V.V Asking user what game type, to compare each line of numbers with
            }while (!gameType.equalsIgnoreCase("Lotto")&&!gameType.equalsIgnoreCase("Plus1")&&!gameType.equalsIgnoreCase("Plus2"));                
                // Prompt for using input and validation of the valid types, ignoring case of the first letter.
           
            eachLine.setGameType(gameType);//V.V setting users value to gameType
            //gameType = "";
            eachLine.setUserNums1(userNums1);//V.V setting users value to userNums1
            eachLine.setUserNums2(userNums2);//V.V setting users value to userNums2
            eachLine.setUserNums3(userNums3);//V.V setting users value to userNums3
            eachLine.setUserNums4(userNums4);//V.V setting users value to userNums4
            eachLine.setUserNums5(userNums5);//V.V setting users value to userNums5

            objectLines.add(eachLine);//V.V Adding eachLine object to ArrayList called objectLines
        }

        myLotto.compareNums();//V.V Calls for the compareNums method

        //V.V Outputs how many numbers have been guessed in each line.
        System.out.println("Amount of Numbers Guessed in Line 1 Total :" + myLotto.getCountLine1());//Line1
        System.out.println("Amount of Numbers Guessed in Line 2 Total :" + myLotto.getCountLine2());//Line2
        System.out.println("Amount of Numbers Guessed in Line 3 Total :" + myLotto.getCountLine3());//Line3

        //C.M.Output results per line to the user in 1 JOptionPane window
        JOptionPane.showMessageDialog(null, "Amount of Numbers Guessed in Line 1 Total :" + myLotto.getCountLine1() + "\nAmount of Numbers Guessed in Line 2 Total :" + myLotto.getCountLine2() + "\nAmount of Numbers Guessed in Line 3 Total :" + myLotto.getCountLine3() + "\nThank you for playing:)");

    }
}
