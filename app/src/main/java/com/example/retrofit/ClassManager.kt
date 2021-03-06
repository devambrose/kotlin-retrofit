package com.example.retrofit

class Posts(val id:String,val description:String,val timeStamp:String,val content:String)

class Post(val items:List<Posts>)

class Users(val id :Int,val username: String,val email:String,val name:String)