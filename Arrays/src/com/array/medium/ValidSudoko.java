package com.array.medium;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/description/

public class ValidSudoko {

}

class Solution4g21 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> boardNumbers = new HashSet<>();
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (board[row][col] != '.') {
                    String numberPosition = "(" + board[row][col] + ")";
                    if (!boardNumbers.add(numberPosition + row) || !boardNumbers.add(col + numberPosition)
                            || !boardNumbers.add(row / 3 + numberPosition + col / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

class Solutionjk29h {
    public boolean isValid(char[][] board,int row , int col ,int num){
        //check row;
        for(int j =0;j<9;j++){
            if(board[row][j]==num)return false;
        }
        //check column;
        for(int i =0;i<9;i++){
            if(board[i][col]==num)return false;
        }

        //check 3*3 matrix;
        //sRow =starting Row;//sCol =starting Col;
        int sRow = (row/3)*3;
        int sCol =(col/3)*3;

        for(int i =sRow ;i<sRow+3;i++){
            for(int j =sCol ;j<sCol+3;j++){
                if(board[i][j]==num)return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i =0;i<9;i++){
            for(int j =0 ;j<9;j++){
                char num =board[i][j];
                if(num=='.')continue;
                board[i][j]='.';
                if(isValid(board ,i,j,num)==false)return false;
                board[i][j]=num;
            }
        }
        return true;
        
    }
}