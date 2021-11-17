package com.example.ownworkplace.leetcode.top100likedquestions.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class First_Unique_Character_In_String {
    static String noUniqueCharInString = "Either all characters are repeating or string is empty";
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        log.info("Enter String:- ");
        String str = sc.next();
        log.info("Enter number to which way you want to solve Problem:- ");
        log.info("1: Brute Force attack, which take o(n^2): ");
        log.info("2: HashMap and Two-string method traversals, which take o(n) and space Complexity o(n): ");
        log.info("3: HashMap and One-string method traversals, which take o(n) and space Complexity o(n): ");
        log.info("4: Using String functionality, which take o(n^2) and space Complexity o(1): ");

        int wayNumber = sc.nextInt();

        switch (wayNumber){
            case 1:
                log.info("You solve using Brute Force attack, which take o(n^2)");
                solveUsingBruteForce(str);
                break;
            case 2:
                log.info("You solve using HashMap and Two-string method traversals, which take o(n) and space Complexity o(n)");
                solveUsingHashMapAndTwoStringTraversal(str);
                break;
            case 3:
                log.info("You solve using HashMap and One-string method traversals, which take o(n) and space Complexity o(n)");
                solveUsingLinkedHashMapAndOneStringTraversal(str);
                break;
            case 4:
                log.info("You solve using Using String functionality, which take o(n^2) and space Complexity o(1):");
                solveUsingStringFunctionality(str);
                break;
            default:
                log.info("You not select any valid way to solve this problem");
                break;
        }
    }

    private static void solveUsingBruteForce(String str) {
        log.info("This is in Progress {} !!", str);
    }

    private static void solveUsingStringFunctionality(String str) {
        char uniqueChar = ' ';
        for(Character ch : str.toCharArray()){
            if(str.indexOf(ch) == str.lastIndexOf(ch)){
                uniqueChar = ch;
                break;
            }
        }
        log.info(uniqueChar == ' ' ? noUniqueCharInString
                : "First non-repeating character is {}", uniqueChar);
    }

    private static void solveUsingLinkedHashMapAndOneStringTraversal(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        getCountOnlyFrequencyOfCharacter(str,map);
        char ch=' ';
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                ch = entry.getKey();
                break;
            }
        }
        log.info(ch == ' ' ? noUniqueCharInString
                : "First non-repeating character is {} ", ch);

    }

    private static void solveUsingHashMapAndTwoStringTraversal(String str) {
        Map<Character, Integer> map = new HashMap<>();
        getCountOnlyFrequencyOfCharacter(str,map);
        int firstUnqCharIndex = firstNonRepeating(str,map);
        log.info(firstUnqCharIndex == -1 ? noUniqueCharInString
                : "First non-repeating character is {} ",
                 str.charAt(firstUnqCharIndex));
    }

    private static int firstNonRepeating(String seq, Map<Character, Integer> map) {
        int index = -1;
        for(int i = 0; i < seq.length(); i++){
            if(map.get(seq.charAt(i)) == 1){
                return i;
            }
        }
        return index;
    }

    private static void getCountOnlyFrequencyOfCharacter(String seq, Map<Character, Integer> map) {
        for(int i = 0; i < seq.length(); i++){
            if(map.containsKey(seq.charAt(i))){
                map.put(seq.charAt(i),map.get(seq.charAt(i))+1);
            }else{
                map.put(seq.charAt(i),1);
            }
        }
    }
}
