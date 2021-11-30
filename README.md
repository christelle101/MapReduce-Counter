# MapReduce-Counter
## Context
MapReduce is a processing algorithm for distributed computing based on Java. 
### Map 
The Map task takes a set of data and converts it into another set of data, where individual elements are broken into tuples (key/value pairs).

### Reduce
The Reduce task takes the output from Map as an input and combines those data tuples into a smaller set of tuples.

## Project classes
### Divider (branch 1)
The Divider class takes the initial text file and divides it into the specified number of chunks.

### Map (branch 2)
The Map extends the Java class Thread and takes into argument the output of Divider (a list of Strings) and creates a list of hashmaps with the words occurring one time.
### Reduce (branch 3)
The Reduce class takes a list of lists of hashmaps. Each hashmap represents a word in the text. Reduce counts the number of occurrences of a word and loads it into a list of hashmaps. It also extends the Java class Thread. 
### Partitioner (branch 3)
Partitioner is in charge of distributing the load of work to the mappers, and then to the reducers once the mapping work is done.
### Test (branch 3)
Main class.

## Conception choices 
We chose to vary the numbers of mappers and use a unique reducer.
## Made with
- [Eclipse](https://www.eclipse.org/)
- [Java](https://www.java.com/fr/)
- Multithreading

## How to use the project 
Clone the repository using the following command :
> $ git clone <https://github.com/christelle101/MapReduce-Counter.git>

Do not forget to reunite all class files and your text file into the same directory;


## Results to be provided 
A count of the occurrences of each word in the text.