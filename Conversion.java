import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Conversion{

   //returns an array of 0's and 1's constructed by represnting each character
   // in s by its assigned bit pattenr  
   public static String stringToBitseq(String S){
      String keys = "_0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      char[] keyArray = keys.toCharArray();

      char[] charArray = S.toCharArray();

      int[] numArray = new int[charArray.length]; //new int[63];
      int num_index = 0;
      for(int i=0; i < keyArray.length; i++){
         for(int j=0; j < charArray.length; j++){
            if(keyArray[i] == charArray[j]){
               numArray[num_index] = i;
      //         System.out.println(num_index);
               num_index++;
            }
         }
      }
      String temp;
      String[] binaryArray = new String[numArray.length];
      for(int i=0; i < numArray.length; i++){
          binaryArray[i] = Integer.toBinaryString(numArray[i]);
          //binaryArray[i] = Integer.parseInt(temp);
      }
      String newString = "";
      for (String s : binaryArray) {

      String str;
      int length = s.length();
      char[] c = s.toCharArray();
      
      if(length == 1){
         int pad = 5;
         c = (new String(new char[pad]) + s).toCharArray();
         Arrays.fill(c, 0, pad, '0');
      //   System.out.println(c);
      }

      if(length == 2){
         int pad = 4;
         c = (new String(new char[pad]) + s).toCharArray();
         Arrays.fill(c, 0, pad, '0');
      //   System.out.println(c);
      }

      if(length == 3){
         int pad = 3;
         c = (new String(new char[pad]) + s).toCharArray();
         Arrays.fill(c, 0, pad, '0');
      //   System.out.println(c);
      }

      if(length == 4){
         int pad = 2;
         c = (new String(new char[pad]) + s).toCharArray();
         Arrays.fill(c, 0, pad, '0');
      //   System.out.println(c);
      }

      if(length == 5){
         int pad = 1;
         c = (new String(new char[pad]) + s).toCharArray();
         Arrays.fill(c, 0, pad, '0');
      //   System.out.println(c);
      }
 
      if(length == 0){
         int pad = 6;
         c = (new String(new char[pad]) + s).toCharArray();
         Arrays.fill(c, 0, pad, '0');
      //   System.out.println(s);
      }
        str = String.valueOf(c);
        newString += str;
      }
    //  System.out.println(newString);
      return newString;
  
   }

   // Returns an array of numbers in the range[0...2^k -1]
   public static int[] BitseqToDigitseq(String bs, int k){
      
	  // This method adds trailing "_" to strings in which their length is < 16
	  int remainingToAdd = 0;
		if(bs.length() < 16){
			remainingToAdd = 16 - bs.length();
		}
		for(int p = 0; p < remainingToAdd; p++){
			bs = bs.concat("_");			
		}
	  // End of adding trailing "_" method
	  
	  
	  String bits = stringToBitseq(bs);
      char[] charArray = bits.toCharArray();
      int[] bitArray = new int[charArray.length];
      int[] intArray = new int[bitArray.length/k];
      for(int i=0; i < bits.length(); i++){
           bitArray[i] = Character.getNumericValue(charArray[i]);
      }
      int sum = 0;
      int j = 0;
      int l = 0; 
      for(int i=0; i < bitArray.length; i++){
        sum += bitArray[i] * Math.pow(2, (k-1) - j);
        if(j == (k-1)){
           intArray[l] = sum;
           l++;
      //     System.out.println(sum);
           sum=0;
           j=0;
        }else{
        j = j+1;
        }
      }
      return intArray;
   }


}
