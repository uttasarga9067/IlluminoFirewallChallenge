## Illumino Firewall Challenge
#### The Code comprieses of a functionality by which the System can filter out the IP Addresses entering and leaving the Machine. There are Certain Set of Pre-Determined rules by which the System makes the Call. This type of enhancement in a System helps to increase the Security of the System and also mitigates risks and notify about any kind of Cyber-Security Attacks.

## Files and their Purpose
#### 1: Firewall.java: Consists Various IP-Addresses which are passed to the System and checks whether they should be allowed or blocked.
#### 2: Rule.java: Consists Functionalities which helps to filter out various ranges of Ports and IP-Addresses.
#### 3: input.csv: Consists pre-determined rules on the basis of which the System checks the incoming Traffic.

## Working of the Application
#### 1: Firewall.java: After Declaring an Array, I used a Split function in order to split the ranges and then delcared two different variables to store the two numbers obtained. I used a Hashset in order to store the new set of rules that I obtained by Iterating a For loop for both the minimum and maximum numbers of Port and IP Address. Here, I used two nested for loops, which means that the Complexity will be O(n^2). Then the Function Accept packet takes the Input of 3 Strings and one Integer and checks if the Input is confined within the Conditions provided to the System.
#### 2: Rule.java: In this file, I have converted IP Address to String by replacing the "." with a empty String and since I am using a HashSet Implementation, I am using equals and Hashcode methods in order to store and retrieve the inputs from the Firewall Class; provided to the System. We need to override both the methods so that their Contract is not voilated.

## Enhancements
#### 1: Complexity: Compelxity of the Code is the most important aspect when it comes to Large Scale Software Implementation. I would have implemented a Data Structure in which instead of iterating through and checking each and every rule; a certain rule can be mapped to a single Object and then checking the Input with the Same would have increased the Code's Linear Time Complexity.
#### 2: A better way of accepting Inputs in order to check for a large number of Datasets. This could have been done by automating the process of accepting IP-Address Inputs by running a Bash Script.

## I would like to provide my preferences according to the Ranking below:
#### 1: Platform Team
#### 2: Policy Team
#### 3: Data Team
