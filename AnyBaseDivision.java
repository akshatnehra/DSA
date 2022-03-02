// // take input base, b and a for (b-a)

// int count = 0
// while(b>0)(
//  //keep subtracting a from b
//  b = anyBaseSubtraction(b,a, base);
//  //keep increasing count count
//  count = anyBaseAdd(count,l, base);
// }


import java.util.*;
public class Main {
   public static void main(String args[]) {


      Scanner scn = new Scanner(System.in);
      int a = scn.nextInt(); 
      int b = scn.nextInt(); 
      int base = scn.nextInt();

      int count = 0; // keeps count in base
      int testCounter=0; // keeps count in decimal

      while(b>=a){
         // b-a
         b = anyBaseSub(a, b, base);
         // count++
         count = anyBaseAdd(count,1, base); 
         testCounter++;        
      }

      System.out.println("Base Counter: "+count); 
      System.out.println("Decimal Counter "+testCounter);
   }

//Subtraction
public static int anyBaseSub(int a, int b, int base){ 
  int answer = 0;
  int power = 1; 
  int carry = 0;

  while(b!=0){

     int sum = (b%10)-(a%10)-carry;

     if(sum >= 0) 
       carry = 0; 
     else{
       carry = 1; 
       sum += base;
     }

     answer += sum*power;

     b/=10; 
     a/=10; 
     power*=10;
  }

  return answer;
}


// ADDITION
public static int anyBaseAdd(int a, int b, int base){

  if(a==0) // initially a is 0
     return b;

  int answer = 0; 
  int power = 1; 
  int carry = 0;

  while(a!=0){

     int sum = (b%10)+(a%10)+carry;

     if(sum < base) 
       carry = 0; 
     else{
       carry = 1;
       sum %= base;
     }

     answer += sum*power;

     b/=10; 
     a/=10;
     power*=10;
}

  // if carry remains after processing 
  if(carry>0)
     answer += carry*power;

  return answer;
}
}
