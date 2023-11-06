import java.util.HashMap;
import java.util.Map;

public class AssigOne {
    // Non-Recursive (Iterative) Implementation
    // Time Complexity: O(n)
    public static int fibonacciNonRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // Recursive Implementation
    // Time Complexity: O(2^n) - Exponential time complexity
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Memoized (Recursive with Memoization) Implementation
    // Time Complexity: O(n)
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacciMemoized(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        
        // Non-Recursive (Iterative) Fibonacci
        int nonRecursiveResult = fibonacciNonRecursive(n);
        System.out.println("Non-Recursive: The " + n + "-th Fibonacci number is " + nonRecursiveResult);
        
        // Recursive Fibonacci
        int recursiveResult = fibonacciRecursive(n);
        System.out.println("Recursive: The " + n + "-th Fibonacci number is " + recursiveResult);
        
        // Memoized (Recursive with Memoization) Fibonacci
        int memoizedResult = fibonacciMemoized(n);
        System.out.println("Memoized (Recursive with Memoization): The " + n + "-th Fibonacci number is " + memoizedResult);
    }
}
