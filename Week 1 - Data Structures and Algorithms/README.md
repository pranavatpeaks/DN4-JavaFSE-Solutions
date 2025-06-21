*** Exercise 2: E-commerce Platform Search Function

Scenario:

You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.

Steps:

1. Understand Asymptotic Notation:
  - Explain Big O notation and how it helps in analyzing algorithms.
    Big O notation is used to describe how the runtime or space requirements of an algorithm grow as the input size increases. It helps us compare algorithms based on their scalability and efficiency. Big O abstracts away actual time/memory and focuses only on growth behavior, not specific machines or languages. It identifies slow parts in your code for optimization.

  - Describe the best, average, and worst-case scenarios for search operations.

    --image should come here--
    
    It’s the shape of the curve that shows the efficiency of an algorithm. Some common running times we may see are:
  	•	O(n^2)
  	•	O(n \log n)
  	•	O(n)
  	•	O(\log n)
  	•	O(1)

    Of the running times above, O(n^2) is considered the worst running time, and O(1) is the fastest.
      	•	Linear search was of order O(n) because it could take n steps in the worst case to run.
      	•	Binary search was of order O(\log n) because it would take fewer and fewer steps to run even in the worst case.
  
  

3. Implementation:
  - Implement linear search and binary search algorithms.
  - Store products in an array for linear search and a sorted array for binary search.
4. Analysis:
  - Compare the time complexity of linear and binary search algorithms.
  - Discuss which algorithm is more suitable for your platform and why.


1. Explain Big O notation and how it helps in analyzing algorithms.
   Big O notation is used to describe how the runtime or space requirements of an algorithm grow as the input size increases. It helps us compare algorithms based on their scalability and efficiency. Big O abstracts away actual time/memory and focuses only on growth behavior, not specific machines or languages. It identifies slow parts in your code for optimization.

2. Describe the best, average, and worst-case scenarios for search operations.

  -- image here 
  In the above graph, the first algorithm is O(n) or in the order of n. The second is in O(n) as well. The third is in O(\log n).
  
  It’s the shape of the curve that shows the efficiency of an algorithm. Some common running times we may see are:
  	•	O(n^2)
  	•	O(n \log n)
  	•	O(n)
  	•	O(\log n)
  	•	O(1)
  
  Of the running times above, O(n^2) is considered the worst running time, and O(1) is the fastest.
  	•	Linear search was of order O(n) because it could take n steps in the worst case to run.
  	•	Binary search was of order O(\log n) because it would take fewer and fewer steps to run even in the worst case.
  
  Programmers are interested in both the worst case, or upper bound, and the best case, or lower bound.
