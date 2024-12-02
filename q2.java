import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;


class main{

    static int [][] a2 = new int [1000][];
    public static int index=0;
    
        public static void main(String[] args){
            
    
            String [] a1 = new String[1000];
            int answer=0;
            
            readFile(a1);
            for(int i=0;i<a1.length;i++){
                int[] arr = Arrays.stream(a1[i].split(" ")).mapToInt(Integer::parseInt).toArray();
                //System.out.println("" + Arrays.toString(arr));
    
    
                if(strictlyDecreasing(arr)||strictlyIncreasing(arr)){
                    
                    if(safe(arr)){
                        answer++;
                    }
                }
    
            }
            
            System.out.println(answer);
    
    
    
    
        }
    
    
        public static int[] remove(int[] arr, int in){///removes from a certain idex
            if (arr == null || in < 0 || in >= arr.length)
                return arr;
    
            return IntStream.range(0, arr.length)
                .filter(i -> i != in)
                .map(i -> arr[i])
                .toArray();
        }
    
        public static boolean safe(int [] arr){
    
            
    
            for(int i=0;i<arr.length-1;i++){
                if(Math.abs(arr[i]-arr[i+1])>3){
                    a2[index]=arr;

                    remove(a2[index], i);
                    index++;
                    return(false);
                }
            }
            
            return(true);
        }
    
        public static boolean strictlyIncreasing(int [] arr){
    
            int count = 0;
            int pos = 0;
    
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] <= arr[i - 1]) {
                    count++;
                    pos=i;
                    
                }
            }
    
            if(count>2){
                return false;
            }else if(count == 1){
                a2[index]=arr;

                remove(a2[index], pos);
                index++;
                return false;
        }
        return true;
    }

    public static boolean strictlyDecreasing(int [] arr){

        int count = 0;
        int pos=0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                count++;
                pos=i;
            }
        }

        if(count>2){
            return false;
        }else if(count == 1){
            a2[index]=arr;
            remove(a2[index], pos);
            index++;
            return false;
    }

        return(true);
    }




    public static void readFile(String [] a1){
        int i = 0;
        try {
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                a1[i]=myReader.nextLine();
                i++;
            }

                
        }catch (FileNotFoundException e) {
            System.err.println("File not found: ");
            e.printStackTrace();
        }
    } 

        
    }

