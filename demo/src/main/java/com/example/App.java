package com.example;

import java.io.Console;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.DebugGraphics;

public class App 
{
    public static Stack opStack = new Stack<String>();

    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        String expression = input.nextLine();

        for(int i=0; i< expression.length(); i++){
            if(expression.charAt(i) == ' ') continue; // ignore whitespace;      

            if(expression.charAt(i) >= 47 && expression.charAt(i) <= 57){
                numStack.push(expression.charAt(i) - '0');
            }
            else{
                evalOp(expression.charAt(i));
            }
        }

    }

    public static void evalOp(char op){
        Integer a = (Integer)numStack.pop();
        Integer b = (Integer)numStack.pop();;
        Integer result = 0;
        
        switch(op){
            case '+':
                result = a+b;
                numStack.push(result);
                break;
            case '-':
                result = a-b;
                numStack.push(result);
                break;
            case '*':
                result = a*b;
                numStack.push(result);
                break;
            case '/':
                result = a/b;
                numStack.push(result);
                break;
            default:
                System.out.println("Invalid Operator");
                System.exit(0);
        }

        System.out.println(result);

    }

}

