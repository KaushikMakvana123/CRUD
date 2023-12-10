package com.example.firebase

class Modelclass {


    var firstName : String = ""
    var lastName : String = ""
    var age : String = ""
    var userHobby : String = ""
    var key : String = ""

    constructor(firstName: String, lastName: String, age: String, userHobby: String, key: String)

    {
        this.firstName=firstName
        this.lastName=lastName
        this.age=age
        this.userHobby=userHobby
        this.key=key
    }

    constructor()
    {

    }

}