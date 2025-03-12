

0.upto(4) {
	println "$it"
}

'===execute something multiple times:==='
5.times{
	println "ball"
	println "$it"
}
					
									
0.step(7,2){
	println "$it"
}

'===Looping through items of a list==='
['cat', 'dog', 'hamster'].each {
	name ->
	println name
}

'====Replace for loop with a number range and looping with each item:===='
(6..10).each { 
	number ->
	println number
}

'=====Looping through a map======'
[fruit:'Apple', veggie:'Carrot', car:'Sedan'].each {
	key, value ->
	println "${key} = ${value}"
}
'===Will output==='
/*	fruit = Apple
	veggie = Carrot
	car = Sedan     */

						
						
						