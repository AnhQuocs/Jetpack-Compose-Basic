package com.example.syt

class Demo {
    fun login() {
        val checkEmail = CheckEmail()
        checkEmail.check("a@t.com")

        checkEmail check "q@a.com"
    }
}

class CheckEmail {
    infix fun check(email: String) {

    }
}