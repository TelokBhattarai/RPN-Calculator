package com.example;

import java.io.Console;
import java.io.EOFException;
import java.rmi.ConnectIOException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.DebugGraphics;
import javax.swing.plaf.basic.BasicScrollPaneUI;

public class App 
{
    public static Stack numStack = new Stack<Integer>();

    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        String pInput = "";

        String num = "";

        Boolean escape = false;

        while(!escape){
            System.out.print("> ");
            pInput = input.nextLine();

            for(int i=0; i<pInput.length(); i++){
                if(pInput.charAt(i) >= 48 && pInput.charAt(i) <= 57) 
                {
                    //System.out.print(pInput.charAt(i));
                    num += pInput.charAt(i);
                    continue;
                }

                if(num.length() > 0){
                    numStack.push(Integer.parseInt(num));
                    num = "";
                    continue;
                }

                System.out.println(numStack);
                System.out.print(pInput.charAt(i));
                evalOp(pInput.charAt(i));
            }

            numStack.clear();
            num = "";
        }

        input.close();
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

