# reengineering_2

1. Start variable must be renamed to startAppTime.
2. Path "src/edu/pro/txt/harry.txt" must be moved to the constant HARRY_POTTER_TEXT_PATH_STRING.
3. cleanText method must be deleted because it is not used and it repeats code in main method.
4. content variable must be renamed to harryPotterText.
5. Regexes must be converted to the constants.
6. Constant strings that are passed to methods must be converted to the constants.
7. Comments must be deleted or be more informative.
8. distinctString must be renamed to distinctWordsString and must be converted to the StringBuilder type.
9. Obtaining a value from an array by the same index several times must be avoided. A separate variable must be created.
10. distincts word is incorrect and must be renamed to distinctWords.
11. A space must be presented between the parenthesis and the curly brace.
12. Unnecessary System.out.println("------"); must be deleted.
13. Unused imports must be deleted.
14. There must be no space in loop condition between a colon and a condition.
15. Lambda break must be immediately after the arrow.
16. Retirement of distinctWords must be changed in order to work correctly and not loose some words.
