# Regression Verfication via Fuzz Testing
write a Java code that can check the program equivalence.
This regression verification tool can formally demonstrate that any incremental modification does not disrupt the pre-existing functionality of the software.
Nomally the regression verification works with formal verification. But in general formal verification is difficult to understand.
Therefore, fuzz testing is utilised. In order to use fuzz testeing JQF, a platform for performing coverage-guided fuzz testing in Java is used. 
write QuickCheck-style test methods that take inputs as formal parameters. JQF instruments the test program’s bytecode and continuously executes tests using inputs that are generated in a coverage-guided fuzzing loop. Then test program is continuously executed and If the program crashes, a bug is found.
implement this tool in the code to find equivalent or inequivalent behaviours. 


reference
https://github.com/rohanpadhye/JQF
