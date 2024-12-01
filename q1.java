import java.io.*;
import java.util.Scanner;
import java.util.Arrays;


class main{

    public static void main(String[] args){
        int[] a1 = new int[1000];
        int [] a2 = new int[1000];
        int ans = 0;

        readFile(a1, a2);
        Arrays.sort(a1);
        Arrays.sort(a2);

        /*part 1
         * for(int i = 0;i<a1.length;i++){
            ans = ans + Math.abs(a1[i]-a2[i]);
        }
         */
        
         for(int i=0;i<a1.length;i++){
            int temp=0;
            for(int j = 0;j<a2.length;j++){
                if(a1[i]==a2[j]){
                    temp++;
                }
            }
            ans=ans+(temp*a1[i]);
         }

        System.out.println(ans);



    }





    public static void readFile(int [] a1, int [] a2){
        int i = 0;
        int j=0;
        int k=0;
        try {
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextInt()) {
                if(i%2==0){
                    a1[j]= myReader.nextInt();
                    j++;
                }else{
                    a2[k]= myReader.nextInt();
                    k++;
                }
            
            i++;
            
        }
        myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
        }

        
    }

}