package com.example.a17259211.helloworld.ui

fun validarMinimoCaracteres(texto:String, minimo:Int) : Boolean{



    return texto.length >= minimo
}

fun validarTextoComArroba(texto:String): Boolean{

    if(texto.contains("@")){
        return true
    }else{
        return false
    }

}

fun textoContemNumero(texto: String):Boolean{

    if(texto.filter { it.isDigit() }.length > 0){
        return true
    }else{
        return false
    }
}

fun seqNumero(texto: String): Boolean{

    if("0123456789".contains(texto)){
        return true
    }else{
        return  false
    }

}