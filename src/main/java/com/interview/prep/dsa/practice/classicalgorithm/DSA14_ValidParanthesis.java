package com.interview.prep.dsa.practice.classicalgorithm;

import java.util.Stack;

public class DSA14_ValidParanthesis {

    public static void balancedParanthesis(String s ){

        char [] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean flag =true;

        for(int i=0;i<c.length;i++){
            char current = c[i];
            if(current=='{'|| current=='['|| current=='('){
                stack.push(current);
            }
            else if(current==']'|| current=='}'|| current==')'){
                if(stack.isEmpty()){
                    System.out.println("Unbalanced");
                    return;
                }
                char check = stack.pop();
                if(current==')' && check!='('||current=='}' && check!='{'|| current==']' && check!='['){
                    System.out.println("Unbalanced");
                    return;
                }
            }
        }
        if(stack.isEmpty()){
        System.out.println("Balanced");
        }
    }
}
