
def c = { }

println c.class.name
println c instanceof Closure

//anonymous function
// closure are objects
def sayHello = { name ->
    println "Hello, $name"
}

sayHello('Test')

List nums = [1,4,6,7,8]
nums.each({
     println it
})

//closure are object & last argument
def timesTen(num, closure){
    closure(num * 10)
}

timesTen(10, {println it})
timesTen(2, {println it})

timesTen(10) {
    println it
}

timesTen(2) {
    println it
}

//that's way
/*nums.each{
    println it
}*.

/*10.times {
    println it
}*/


import java.util.Random
Random rand = new Random()

3.times{
    println rand.nextInt()
}