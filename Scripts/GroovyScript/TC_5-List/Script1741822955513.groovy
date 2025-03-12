List javaList = new ArrayList()	// Java
def groovyList = [] // GroovyBoth 
		
'==Initializing is simple=='
def glist = [5, 1, 3, 5]

'==And contents are not strongly typed=='
def myList = [10, "John", new Integer(5), new Double(7.6d)]

'==Appending items is like this:=='
def alist = [10, 9, 8]
alist << 7
alist << 6  //printing the contents will result to output: [10, 9, 8, 7, 6]

'==Individual items can be accessed by index=='
def blist = ["Apple", "Banana", "Carrot"]
println blist[1] //==>'Prints Banana.'

'==You can get number of elements using the size() method:=='
def clist = ["Apple", "Banana", "Carrot"]
println clist.size()  // Outputs 3

'==You can get a subset of a list given a criteria:=='
def dlist = [10,11,12,13,14,15,16,17,18,19,20]
println dlist.findAll{it % 2 == 0} //The above will find all elements of the list that satisfies the condition it % 2 == 0 (meaning even numbers.). The output will be: [10, 12, 14, 16, 18, 20]

'==You can create a new list by using each item in a list to evaluate an expression:=='
def elist = [1,2,3,4,5]
println elist.collect{it * 10} //Output will be: [10, 20, 30, 40, 50]

'==Or you can create a new list by invoking a function on each items:=='
def flist = ["Apple", "Basketball", "Championship"]
println flist*.length() //output will be. [5, 10, 12]










