import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.regex.*;


class q3{

   public static int lengtharr=0;
    
        public static void main(String[] args){
            
    
            String [] a1 = new String[1000];
            int answer=0;
            
            readFile(a1);
            

            answer=p2(a1);
            
            System.out.println(answer);
    
    
    
    
        }



    public static int p2(String a1[]){
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String regex = "(don't\\(\\)|do\\(\\))";

        //System.out.println(lengtharr);
        //System.out.print(a1[2]);
        for(int k =0;k<6;k++){

           
            System.out.println();

            String input = a1[k];

            try{

                String[] parts = input.split(regex);
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
        
                boolean canAppend = true; 
        
                int partIndex = 0; 
                while (matcher.find()) {
                    if (canAppend && partIndex < parts.length) {
                        sb.append(parts[partIndex]);
                    }
        
                    String match = matcher.group();
                    if (match.equals("don't()")) {
                        canAppend = false;
                    } else if (match.equals("do()")) {
                        canAppend = true;
                    }
        
                    partIndex++;
                }
                if (canAppend && partIndex < parts.length) {
                    sb.append(parts[partIndex]);
                }




        }catch (NullPointerException e) {
            System.err.println("NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

            

        }

        answer = solution(sb.toString());


        return(answer);
        

    }    

    public static int solution(String a1){

        String regex = "mul\\((-?\\d+),(-?\\d+)\\)";
        int answer=0;

        try{
                Pattern pat = Pattern.compile(regex);
                String input = a1;
                //System.out.println(a1[i]);
                Matcher match = pat.matcher(input);
                while(match.find()){
                    
                    answer+=Integer.parseInt(match.group(1))*Integer.parseInt(match.group(2));
                    //System.out.println(answer);
    
    
                }
           
        }catch (NullPointerException e) {
            System.err.println("NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        

        return (answer);
    }    
    
    
 


    public static void readFile(String [] a1){
        int i = 0;
        try {
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                a1[i]=myReader.nextLine();
                lengtharr++;
                i++;
            }

                
        }catch (FileNotFoundException e) {
            System.err.println("File not found: ");
            e.printStackTrace();
        }
    } 

        
    }

