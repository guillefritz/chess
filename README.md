
# chess game 

## objective

make a Chess game domain + basic rules.


## how to play

run chess.cmd.App class

## test

    ./gradlew clean check


### domain

should have domain entities and gaming rules allowing to build several infrastructure implementations

TDD style develop in progress


### cmd

command line implementation


### rest

REST APIs implementation (TODO)


# Play the game

## run

### Option 1: build and run

    ./gradlew build
    java -jar build/libs/chess.jar

### Option 2: run

    ./gradlew run
    
### Option 3: use your IDE
    run App main class
    
## play

every turn (starts White, then Black moves) should enter by stdin:  

    ROL,COL,ROW,COL
    
being first pair the origin, the second pair is the destination coordinate.

    1,0,2,0   (row one, column zero, to row two, same column)
