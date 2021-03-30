
'====Map stores a list of key value pairs. For example:===='
def emptyMap = [:]
def mapWithValues = [fruit:'Apple',  veggie:'Carrot'] 

'The only difference between an empty map and list is the extra colon.'
'It is also an instance of java.util.Map and all keys are Strings by default. Here are sample ways to add and get items from maps:'

def alist = [fruit:'Apple', 'veggie':'Carrot']
alist['car'] = 'Sedan'
alist.put('book', 'Novels')
alist << [pet:'Dog']
println alist['fruit']
println alist.'veggie'
println alist.get('car')
println alist.get('book')
println alist.get('pet')

'====Notice that fruit, even without quotes was treated as String. Map operations such as put and get are also supported.==='