# MapReduce-Counter
## Context
MapReduce is a processing algorithm for distributed computing based on Java. 
### Map
The Map task takes a set of data and converts it into another set of data, where individual elements are broken into tuples (key/value pairs).

### Reduce
The Reduce task takes the output from Map as an input and combines those data tuples into a smaller set of tuples.

## Project classes
### Divider
The Divider class takes the initial text file and divides it into the specified number of chunks.

### Map
The Map extends the Java class Thread and takes into argument the output of Divider (a list of Strings) and creates a list of hashmaps with the words occurring one time.
### Reduce
The Reduce class a list of lists of hashmaps. Each hashmap represents a word in the text. Reduce counts the number of occurrences of a word and loads it into a list of hashmaps. It also extends the Java class Thread. 
### Partitioner
Partitioner is in charge of distributing the load of work to the mappers, and then to the reducers once the mapping work is done.
### Test
Main class.

## Conception choices 
We chose to vary the numbers of mappers and use a unique reducer.
## Made with
- [Eclipse](https://www.eclipse.org/)
- [Java](https://www.java.com/fr/)
- Multithreading s

## How to use the project 

## Results to be provided 