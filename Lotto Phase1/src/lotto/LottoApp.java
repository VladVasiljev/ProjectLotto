/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto;

import javax.swing.JOptionPane;

/**
 * @author Vladislavs Vasiljevs
 * @author Carl Moylan
 * @author Rafal Konarzewski
 */
public class LottoApp {

    public static void main(String[] args) {

        int[][] userNums = new int[3][5];//C.M 2D array with 3 rows for the lines and 5 cols for the user input numbers on each line
        int[] lottoNums; //V.V 1D array with 5 indexs

        //V.V Declaring and creating object
        Lotto myLotto = new Lotto();

        //V.V Generates the random numbers
        myLotto.compute();

        lottoNums = myLotto.getLottoNums();
        myLotto.setLottoNums(lottoNums);
        for (int i = 0; i < lottoNums.length; i++) {
            System.out.println(lottoNums[i]);
        }

        //INPUT
        //C.M to get the numbers from the user: two loops, one for the lines and one for the numbers on each line
        for (int lineCounter = 0; lineCounter < userNums.length; lineCounter++) {
            //C.M  We can pick any of the 3 top level array elements (ie any row) to get the length for the second level (columns)...
            for (int numCounter = 0; numCounter < userNums[0].length; numCounter++) {
                //C.M  The "+ 1" is to show a normal looking line and number to the user i.e. doesn't start at 0
                userNums[lineCounter][numCounter] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number for line " + (lineCounter + 1) + ", number " + (numCounter + 1) + " : "));

                if (userNums[lineCounter][numCounter] < 1 || userNums[lineCounter][numCounter] > 40) {
                    JOptionPane.showMessageDialog(null, "That is not a valid number!!!\nStart again");
                    lineCounter = -1;//C.M resets to recieve input for the 1st number on line 1
                    break;//C.M  restarts the outer loop to recieve new user input
                }
                System.out.print(userNums[lineCounter][numCounter] + ", ");//C.M Prints to the console the userNums numbers entered to the 2D array
            }
        }

        myLotto.setUserNums(userNums);//C.M sending the 2D array called userNums to instantiable class.  The array contains all the lotto numbers input by the user//V.V - Changed myUserNums to myLotto 22/10/16
        myLotto.compareNums();//V.V Calls for the compareNums method, which is used for comparing the lottoNums to UserNums

        //V.V Outputs how many numbers have been guessed in each line.
        System.out.println("Amount of Numbers Guessed in Line 1 Total :" + myLotto.getCountLine1());//Line1
        System.out.println("Amount of Numbers Guessed in Line 2 Total :" + myLotto.getCountLine2());//Line2
        System.out.println("Amount of Numbers Guessed in Line 3 Total :" + myLotto.getCountLine3());//Line3

        //C.M.Output results to the user in 1 JOptionPane window
        JOptionPane.showMessageDialog(null, "Amount of Numbers Guessed in Line 1 Total :" + myLotto.getCountLine1() + "\nAmount of Numbers Guessed in Line 2 Total :" + myLotto.getCountLine2() + "\nAmount of Numbers Guessed in Line 3 Total :" + myLotto.getCountLine3() + "\nThank you for playing :)");

    }
}
