def map = [:]
println map
println map.getClass().getName()

def person = [first:"Andreea", last:"Marina"]
println person
println person.first

person.email="test"
println person


for (entry in person){
    println entry
}

for (key in person.keySet()){
    println "$key:${person[key]}"
}

//each and eachWithIndex TO SEE on closures