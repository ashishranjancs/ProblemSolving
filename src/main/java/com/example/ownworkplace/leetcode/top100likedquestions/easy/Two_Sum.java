package com.example.ownworkplace.leetcode.top100likedquestions.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Two_Sum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        log.info("Enter the Size of int Array:- ");
        int intArrSize = sc.nextInt();
        int[] intArr = new int[intArrSize];
        log.info("Enter int Array of size {} ", intArrSize);
        for(int i = 0; i < intArrSize; i++){
            intArr[i] = sc.nextInt();
        }
        log.info("Enter the target Value: ");
        int target = sc.nextInt();
        log.info("Enter number to which way you want to solve the Problem:- ");
        log.info("1: Brute Force attack, which take o(n^2): ");
        log.info("2: HashMap and one method traversals, which take o(n) and space Complexity o(n): ");
        int wayNumber = sc.nextInt();

        switch (wayNumber){
            case 1:
                log.info("You solve using Brute Force attack, which take o(n^2)");
                solveUsingBruteForce(intArr, target);
                break;
            case 2:
                log.info("You solve using HashMap and One traversals, which take o(n) and space Complexity o(n)");
                solveUsingHashMapAndOneTraversal(intArr, target);
                break;
            default:
                log.info("You not select any valid way to solve this problem");
                break;
        }

    }

    private static void solveUsingBruteForce(int[] intArr, int target) {
        log.info("It is in progress....");
        List<Integer> pairs = new ArrayList<>();
        for(int i = 0; i < intArr.length; i++){
            for(int j = i+1; j < intArr.length; j++){
                if(intArr[i] + intArr[j] == target){
                    pairs.add(i);
                    pairs.add(j);
                }
            }
        }
        log.info("Pairs of index which have target value is: {}", pairs);
    }

    private static void solveUsingHashMapAndOneTraversal(int[] intArr, int target) {
        Map<Integer, Integer> valueWithIndexMap = new HashMap<>();
        List<Integer> pairs = new ArrayList<>();
        for(int  i = 0; i < intArr.length; i++){
            int complement = target - intArr[i];
            if(valueWithIndexMap.containsKey(complement)){
                pairs.add(valueWithIndexMap.get(complement));
                pairs.add(i);
            }else{
                valueWithIndexMap.put(intArr[i],i);
            }
        }
        log.info("Pairs of index which have target value is: {}", pairs);
    }
}
