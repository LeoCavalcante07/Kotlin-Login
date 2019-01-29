package com.example.a17259211.helloworld

import junit.framework.Assert
import org.junit.Test

class ValidacoesCadastroTeste {

    @Test
    fun validarCaracteresSucesso(){
        val input = "Arie"
        val resultadoEsperado = true

        val resultado = validarMinimoCaracteres(input, 3)

        Assert.assertEquals(resultadoEsperado, resultado)
    }


    @Test
    fun validarDoisCaracteresSucesso(){
        val input = "Ar"
        val resultadoEsperado = false

        val resultado = validarMinimoCaracteres(input, 3)

        Assert.assertEquals(resultadoEsperado, resultado)
    }


    @Test
    fun validarTresCaracteresSucesso(){
        val input = "Ari"
        val resultadoEsperado = true

        val resultado = validarMinimoCaracteres(input, 3)

        Assert.assertEquals(resultadoEsperado, resultado)
    }


    @Test
    fun `validar arroba no email`(){

        val input = "joao@uol"
        val resultadoEsperado = true


        val resultado = validarTextoComArroba(input)

        Assert.assertEquals(resultadoEsperado, resultado)

    }

    @Test
    fun `senha com menos de 4 caracteres`(){

        val input = "abc"
        val resultadoEsperado = false


        val resultado = validarMinimoCaracteres(input, 4)

        Assert.assertEquals(resultadoEsperado, resultado)

    }


    @Test
    fun `senha com numeros`(){

        val input = "oi2"
        val resultadoEsperado = true

        val resultado = textoContemNumero(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }

    @Test
    fun `senha com sequencia de numeros`(){

        val input = "12aaa"
        val resultadoEsperado = false

        val resultado = seqNumero(input)

        Assert.assertEquals(resultadoEsperado, resultado)
    }



}