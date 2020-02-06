package com.company.easy._374;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * </p>
 * DATE 2020/2/6.
 *
 * @author genglintong.
 */
public class Solution extends GuessGame{
    public int guessNumber(int n) {
        int mid , res,start = 1, end = n;
        while (start <= end) {
            mid = start + (end - start) /2;
            res = guess(mid);
            if (res == 0) {
                return mid;
            }else if (res < 0) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(10));
    }
}

class GuessGame {
    static int PICK = 6;
    public int guess(int num) {
        if (num == PICK) {
            return 0;
        }else if (num < PICK) {
            return 1;
        }else {
            return -1;
        }
    }
}
