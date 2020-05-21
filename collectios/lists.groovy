package com.test

def nums = [1,2,3,4,5,6,7,8,9]

println nums
println nums.class.name

//add
nums.push(99)
nums.putAt(0,77)
nums[0]=100
nums << 66

println nums
println nums + [3,4,6]
println nums

//remove
nums.pop()
//nums.removeAt(0)
def newList = nums - 1
println nums
println newList


//get
println nums.getAt(0..3)
println nums

//clear
nums.clear()
nums = []

//to see in closures
for (x in nums){
    println x
}