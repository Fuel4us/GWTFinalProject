**Tiago Correia** (1140403) - Sprint 2 - IPC02.3
===============================

# 1. General Notes

*In this section you should register important notes regarding your work during the sprint. For instance, if you spend significant time helping a colleague or if you work in more than one feature increment.*

# 2. Requirements

IPC02.3 - Global Search/Replace

The application should now support "Search" and "Search and Replace" to be 
applied for all the workbooks of the user (may they be active/open or not). 

In a more brief text:

In this iteration of the use casa about "search and replace", it was required
that now, instead of looking for a certain expression in the current workbook,
it should now look in all the workbooks of the user.

Sub-Issues:
US1 - As a user I want to be able replace one occurrence of my desired expression 
at a time.

US2 - As a user I want to be able to replace all occurrences of my specified 
expression

# 3. Analysis

*In this section you should describe the study/analysis/research you developed in order to design a solution.*


Use case diagram:

![UseCase](UseCase.png)

For this feature increment I need to:  

- Understand how the application works and also understand the key aspects of GWT, since it is the main technology behind the application  
- Understand how to integrate a relational database into the project (Will be assuming JPA since it is studied in EAPLI)  

## 3.4 Analysis Diagrams

Use case diagram:

![UseCase](UseCase.png)

SSD's:
SSD for US1
![SSDUS1.jpg](SSDUS1.jpg)
SSD for US2
![SSDUS2.jpg](SSDUS2.jpg)


**Domain Model (for this feature increment)**

![Domain Model](CDCore02.3.jpg)

**System Sequence Diagrams**

**For US1 and US2**

Replace one ocurrance US1:
![Design-Core 02.3.jpg](Core02.3S1.jpg)

Replace All US2:
![Design-Core 02.3.jpg](Design-Core02.3.jpg)

# 4 Design
## 4.1 TESTS

### Test Search And replace
1. User requests the search of a certain expression
2. System finds the first/next cell that contains the specified expression
4. User requests a change in the cell contents
5. The cell content is changed

### Test Replace All
1. User requests that all cells that contain the specified expression are changed
2. The system finds all occurrences of the expression in the workbooks of the user
and changes the content of all cells.


## 4.2. Requirements Realization

*In this section you should present the design realization of the requirements.*

Following the guidelines for JPA from EAPLI we envision a scenario like the 
following for realizing the use cases for this feature increment:

Controller print:
![codePrint.png](codePrint.png)

Essentially this use case, from the previous iteration, changed in the fact that
instead of looking for a certain expression in the cells of the active workbook,
it should look for it in all the workbooks of the user.

For that I evolved the method above, that allows the program to search and save 
all the cells from all the User's workbooks that correspond to the expression
introduced.

From here on, since i already knew the cells that needed to be changed, all i needed
was to change the content of the cells.

## 4.3. Classes

*Present and describe the major classes of you solution.*

## 4.4. Design Patterns and Best Practices

*Present and explain how you applied design patterns and best practices.*

By memory we apply/use:
- Singleton, across multiple classes
- Repository, in the package Server
- DTO, in the package Shared
- MVP, in the package NSheets
- GRASP, GoF, SOLID and DDD, where shown in some classes and relations bettween classes.
	For instance, we have controller pattern in controller classes, pure fabrication in the factory's done by Server,  high cohesion and low coupling especially important for Shared package and many moore.

