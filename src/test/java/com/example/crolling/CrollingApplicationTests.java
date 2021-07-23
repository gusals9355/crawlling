package com.example.crolling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Scanner;

@SpringBootTest
class CrollingApplicationTests {

    @Test
    void contextLoads() {

    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        BigInteger a = sc.nextBigInteger();
//        BigInteger b = sc.nextBigInteger();
//        System.out.println(a.add(b));
//    }

    public static void main(String[] args) {
        solution(5);
    }
    public static void solution(int N){
        int n=N+2;
        int cnt = 0;
        int[][] pan = new int[n][n];

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i>0 && i<n-1 && j>0 && j<n-1){
                    int random = (int)(Math.random()*9)+1;
                    pan[i][j] = random;
                }
                System.out.print(pan[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=============");
        for (int i=1; i<n-1; i++){
            for(int j=1; j<n-1; j++){
                int value = pan[i][j];
                if(value > pan[i][j+1] && value > pan[i][j-1] && value > pan[i+1][j] && value > pan[i-1][j]){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}
