# Ikedi Ufomadu
## Development Specifications
### Java 17
### Javac 17.0.2
### IntelliJ IDEA 2021.3.3 (Community Edition)

# Compile and run via IDE run function.
### Was not ran with `javac` command

## Program Usage
* User is prompted to enter file to analyze or quit.
* The user can sumbit a path of a file or "quit".
* There are three possible outcomes once file is analyzed:
    1. On event a lexically-invalid token is found, the analysis terminates and reports an error.
    2. On event a syntactically-unexpected token is found, the analysis terminated and reports an error.
    3. IIf no lexical or syntaxical error is found, the analyzer reports completion.
* The user is will then be reprompted for new files, repeating this whole process until they enter "quit".
