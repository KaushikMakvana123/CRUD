package com.example.firebase


class StudentModelClass {

    lateinit var id: String
    lateinit var name: String
    lateinit var email: String
    lateinit var mobile: String
    lateinit var address: String
    lateinit var image: String
    constructor(id:String,name:String,email:String,mobile:String,address:String,image:String){

        this.id=id
        this.name=name
        this.email=email
        this.mobile=mobile
        this.address=address
        this.image=image
    }
    constructor(){

    }
}