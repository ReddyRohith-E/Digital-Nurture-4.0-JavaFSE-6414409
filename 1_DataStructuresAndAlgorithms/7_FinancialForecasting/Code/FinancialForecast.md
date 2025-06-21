# Exercise 7: Financial Forecasting

## 1. Recursive Algorithms

Recursion is a technique in programming where a function calls itself to solve a problem by breaking it into smaller, similar tasks. This approach is helpful for problems that naturally fit a repetitive pattern, such as calculating factorials, navigating tree structures, or projecting future values from historical data.

## 2. Recursive Future Value Calculation

To estimate the future value of an investment with a fixed annual growth rate, you can use a recursive approach. The calculation works as follows:

```
futureValue(years) = futureValue(years - 1) * (1 + growthRate)
Base case: futureValue(0) = initialAmount
```

## 3. Analysis

### Time Complexity

- The recursive solution has a time complexity of **O(n)**, where `n` is the number of years, since each year results in one recursive call.

### Optimization

- For most practical scenarios, recursion is efficient unless the number of years is extremely high, which could risk a stack overflow.
- A more efficient approach uses the compound interest formula:
  ```
  futureValue = initialAmount * Math.pow(1 + growthRate, years)
  ```
  
  **Mathematical formula:**

  A = P*(1 + r/t)^t

  Where:
  - A = future value
  - P = initial amount (principal)
  - r = growth rate (as a decimal)
  - t = number of periods (years)

This formula calculates the result directly without recursion.