/***********************************************************************************
Docs:- http://grails.asia/grails-tutorial-for-beginners-playing-with-groovy-language
/***********************************************************************************
 * While Declaring Variable in Groovy
 * SomeWhat similar to the Python
 * No need to Write int , string or anything 
 *************************************************************************************/

 def stringDemo1(){
	def b = 'No need to Write int , string or anything to declare Variable'
	println b

	x = 10
	println x //or println('x')
	y = 2.50
	println y
	x = 'apple'
	println x
	x= ['appple','ball','cat']
	println x
	
	'===============Array example=============='
	zz= ['appple','ball','cat']as String[]
	println zz[1]
	// or We can do this
	String[] z =['car','bike','plane']
	println z[2]
	'===========Multiline string==============='
	def x = """a
                   for
                   Apple"""
		println x
}

			
def stringDemo2(){
	def firstName = 'John'
	def lastName = 'Doe'
	def a = 3
	def b = 7

	println "${lastName}, ${firstName}"
	println "a + b = ${a + b}"
	println '${lastName}, ${firstName}'
	println 'a + b = ${a + b}'

}

def StringInterpolationDemo1(String aa){
	'==========String interpolation============'
	println "I love ${aa}"
	
	def person = [name: 'Guillaume', age: 36]
	assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'
}
//NOTE:- R-click-->Run as-->Groovey script
	//stringDemo2()
	
//StringInterpolationDemo1("USA")
	
def StringInterpolationDemo2(){	
	def number = 1
	def eagerGString = "value == ${number}"
	def lazyGString = "value == ${ -> number }"
	
	assert eagerGString == "value == 1"
	assert lazyGString ==  "value == 1"
	
	number = 2
	assert eagerGString == "value == 4"
	assert lazyGString ==  "value == 2"
}

StringInterpolationDemo2()









 