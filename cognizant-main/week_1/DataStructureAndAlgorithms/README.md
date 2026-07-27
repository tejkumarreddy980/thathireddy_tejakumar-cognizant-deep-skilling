Week 1 — Data Structures and Algorithms

Java FSE Deep Skilling (Digital Nurture 5.0)

Cognizant Digital Nurture 5.0 Program


Program Details

FieldDetailsProgramDigital Nurture 5.0 — Deep SkillingTrackJava Full Stack Engineer (Java FSE)ModuleModule 2 — Data Structures and AlgorithmsWeekWeek 1Compiler UsedProgramiz Online Java Compiler


Exercises Completed

Exercise 2: E-Commerce Platform Search Function

File: Exercise2_EcommerceSearch/ProductSearch.java

What it does:


Implements Linear Search and Binary Search on a product catalog
Searches products by their product ID
Compares both algorithms and demonstrates their differences
Handles not-found scenario by returning -1


Concepts Covered:

ConceptDescriptionLinear SearchChecks every element one by one — works on unsorted dataBinary SearchDivides search in half each time — needs sorted dataTime Complexity O(n)Linear Search — worst case checks every elementTime Complexity O(log n)Binary Search — 1000 items needs only ~10 checksReturn -1Standard convention for element not found

Algorithm Comparison:

FeatureLinear SearchBinary SearchWorks on unsorted data✅ Yes❌ NoTime ComplexityO(n)O(log n)1000 items worst case1000 checks~10 checksImplementationSimpleModerateBest forSmall or unsorted dataLarge sorted data

Execution Output:

=== E-Commerce Platform Search Function ===
Total products in catalog: 8

--- Linear Search ---
Product found at index: 4
Product Name : Backpack
Category     : Bags
Price        : Rs.1500.0

--- Binary Search ---
Product found at index: 6
Product Name : Desk Lamp
Category     : Furniture
Price        : Rs.1200.0

--- Searching for non-existing product ---
Product with ID 999 not found in catalog.

--- Algorithm Comparison ---
Linear Search : Checks each element one by one — O(n)
Binary Search : Divides search in half each time  — O(log n)
Binary Search is faster but needs SORTED data.

Status: ✅ Executed Successfully on Programiz Online Java Compiler


Exercise 7: Financial Forecasting

File: Exercise7_FinancialForecasting/FinancialForecast.java

What it does:


Calculates future value of an investment using recursion
Same calculation using iterative approach for comparison
Shows year by year forecast breakdown
Demonstrates two real world scenarios


Concepts Covered:

ConceptDescriptionRecursionMethod that calls itself with smaller input each timeBase CaseStopping condition — when years == 0 return current valueRecursive CaseMultiply by growth rate and reduce years by 1Stack OverflowError that occurs when base case is missingIterationSame result using a for loop instead of recursion

How Recursion Works Here:

calculateFutureValue(100000, 0.08, 3)
    └── calls calculateFutureValue(108000, 0.08, 2)
            └── calls calculateFutureValue(116640, 0.08, 1)
                    └── calls calculateFutureValue(125971, 0.08, 0)
                            BASE CASE REACHED — returns 125971
                    returns 125971 back up
            returns 125971 back up
    returns 125971 back up
Final answer: 125971

Recursive vs Iterative Comparison:

FeatureRecursiveIterativeCode lengthShorter, cleanerLongerMemory usageMore (call stack)LessSpeedSlightly slowerSlightly fasterRiskStack Overflow if no base caseNo such riskBest forProblems breaking into smaller similar problemsSimple repetitive operations

Execution Output:

=== Financial Forecasting Tool ===

--- Scenario 1: Investment Growth ---
Initial Investment : Rs.100000.0
Annual Growth Rate : 8.0%
Forecast Period    : 5 years

Year by Year Forecast:
Year 1 : Rs.108000.00
Year 2 : Rs.116640.00
Year 3 : Rs.125971.20
Year 4 : Rs.136048.90
Year 5 : Rs.146932.81

Final Value after 5 years (Recursive)  : Rs.146932.81
Final Value after 5 years (Iterative)  : Rs.146932.81

Both methods give same result — proves recursion is correct.

--- Scenario 2: Company Revenue Forecast ---
Current Revenue    : Rs.500000.0
Growth Rate        : 12.0%
Forecast Period    : 3 years

Year 1 Revenue : Rs.560000.00
Year 2 Revenue : Rs.627200.00
Year 3 Revenue : Rs.702464.00

--- How Recursion Works Here ---
Step 1: calculateFutureValue(100000, 0.08, 3)
Step 2: calls calculateFutureValue(108000, 0.08, 2)
Step 3: calls calculateFutureValue(116640, 0.08, 1)
Step 4: calls calculateFutureValue(125971, 0.08, 0)
Step 5: years=0, BASE CASE reached, returns 125971
Step 6: results bubble back up through each call

Status: ✅ Executed Successfully on Programiz Online Java Compiler


Repository Structure

Week1_DSA/
│
├── Exercise2_EcommerceSearch/
│   └── ProductSearch.java        # Linear Search and Binary Search implementation
│
├── Exercise7_FinancialForecasting/
│   └── FinancialForecast.java    # Recursive and Iterative financial forecasting
│
└── README.md                     # This file


Key Learnings from Module 2


Binary Search is significantly faster than Linear Search for large datasets
Binary Search requires data to be sorted first
Returning -1 is standard convention for element not found
Recursion breaks a problem into smaller identical subproblems
Base case is mandatory in recursion — without it Stack Overflow Error occurs
Both recursive and iterative approaches give identical results
Iterative approach uses less memory — preferred for very large datasets
Time complexity O(log n) means 1000 items needs only ~10 comparisons



Tools Used

ToolPurposeProgramiz Online Java CompilerWriting and executing Java codeGitHubVersion control and submissionJavaProgramming language


Learning References


Searching Algorithms: https://www.geeksforgeeks.org/searching-algorithms/
Analysis of Algorithms: https://www.geeksforgeeks.org/design-and-analysis-of-algorithms/
Recursion: https://www.geeksforgeeks.org/recursion/
Arrays: https://www.geeksforgeeks.org/array-data-structure-guide/
