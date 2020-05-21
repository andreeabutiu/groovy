package com.test

import groovyx.net.http.HttpResponseDecorator

//ALT+ENTER with a caret positioned on @Grab to download artifact
@Grapes([
        @Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.7.1'),
])

import groovyx.net.http.RESTClient
import org.apache.http.entity.ContentType

String base = 'http://api.icndb.com/'

def chuck = new RESTClient(base)


def param = [firstName: "1stName", lastName: "lastName"]


chuck.contentType = ContentType.APPLICATION_JSON
chuck.get( path: '/jokes/random') { response, json  ->
    println response.status
    println json

    assert response.status == 200
}

/*chuck.get( path: '/jokes/random', param: param) { response, json  ->
    println response.status
    println json

    assert response.status == 200
}*/



String base_restfull_booker = 'https://restful-booker.herokuapp.com'

def restfull = new RESTClient(base_restfull_booker)
restfull.contentType = ContentType.APPLICATION_JSON


println "PING"
restfull.get( path: '/ping') { response ->
    println response.status

    assert response.status == 201 : "test failed" //TODO
}

println "POST auth with error"
restfull.post( path: '/auth') { response, json  ->
    println response.status
    println json

    assert response.status == 200
    assert json.toString().contains("Bad credentials")
}

println "POST auth OK"
def token
restfull.post( path: '/auth',
               body : [ username:'admin', password:'password123' ])
        { response, json  ->

            assert response.status == 200

            json.collect() {key, value ->
                 //println key
                 //println value
                 token = value
            }
        }

println token


//restfull.defaultRequestHeaders.'Cookie' = "token=$token"  TODO

//booking all
restfull.get( path: '/booking') { response, json ->
    println response.status
    println json

    assert response.status == 200
}


//create booking POT /booking
//TODO
/*def test = restfull.post( path: '/booking') { response, json ->
    println response.status
    println json

    assert response.status == 500
}*/


/*

{
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}

 */




//get booking by id
//booking/<id>

//update booking
//PUT /booking/<id> + body
//+ add in header key: Cookie, Value: token={{token}}


//delete booking
//DELETE /booking/<id>
//add in header key: Cookie, Value: token={{token}}


Map<String, String> headers = new HashMap<String, String>(["Cookie": "token=$token"])

restClient.defaultRequestHeaders.'Cookie' = "token=$token"

Map<String, String> headers = new HashMap<String, String>(["Cookie": "token=$token"])
restfull.defaultRequestHeaders << headers
