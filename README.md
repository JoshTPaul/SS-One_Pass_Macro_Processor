# One-Pass Macro Processor

The purpose of this project is to identify and expand macros from the assembley language code provided by the user, in one pass.
The project was written in Java and consists of the following files:

1.  macroprocessor.java:

The main logic is performed by this class. Takes input from IN.txt and provides the output to OUT.txt.

2.  gui.java:

Optional GUI for users to interact with.

3.  IN.txt:

Stores the user's input.
The user can store the required input directly through the GUI. If the user does not wish to do so, they must manually enter and save the contents of this file via a text editor such as Notepad, etc.

4.  OUT.txt:

Stores the output of the macroprocessor.

5.  DEFTAB.txt:

Stores all the macro declarations and respective macro bodies.

6.  NAMTAB.txt:

Stores macro names and their corresponding start and end lines with respect to DEFTAB.txt

7.  ARGTAB.txt:

Stores the arguments passed by the macro invokation statement.

This Minor Project was conducted the following students of CSE 6A, DSCE for the System Software Minor Project:

Jay Prakash Kumar     (1DS17CS047)

Joshua Thomas Paul    (1DS17CS048)

J C Nikhileswar Reddy (1DS17CS049)

K Chandrahas          (1DS17CS050)
