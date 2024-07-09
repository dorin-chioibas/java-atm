# Java ATM app
===================

ATM Simulation in Java

Description
=
Create a Java application that simulates interaction with an ATM. The application will receive information from the command line and allow users to perform basic operations such as checking the balance, depositing money, and withdrawing money. The application must also handle error cases, such as attempting to withdraw more money than is available in the ATM.

Functional Requirements:
=

User Interface:
The application must run in the command line.
The user should be able to select options from a menu: `Check Balance`, `Deposit Money`, `Withdraw Money`, `Exit`.
Operations:
`Check Balance`: Displays the user’s current balance.
`Deposit Money`: Allows the user to add a specified amount to their account.
`Withdraw Money`: Allows the user to withdraw a specified amount from their account. If the requested amount exceeds the available balance, display an error message.

Error Handling:
If the user attempts to withdraw more money than is available in the account, display an error message: `Insufficient funds.`
If the user enters an invalid menu option, display an error message: `Invalid option. Please select a valid option.`

Technical Requirements
=

Input/Output:
Use `Scanner` to read user inputs from the command line.
Display messages and menus in the command line.

Example Usage Flow:

1. The user runs the application.
2. The application displays the main menu.
3. The user selects the “Check Balance” option.
4. The application displays the current balance.
5. The user selects the “Deposit Money” option and enters the amount to deposit.
6. The application updates the balance and displays the new balance.
7. The user selects the “Withdraw Money” option and enters the amount to withdraw.
8. If the amount is available, the application updates the balance and displays the new balance. If not, it displays the error message “Insufficient funds.”
9. The user selects the “Exit” option to close the application.