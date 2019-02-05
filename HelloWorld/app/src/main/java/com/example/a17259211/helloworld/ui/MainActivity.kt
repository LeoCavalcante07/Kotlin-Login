package com.example.a17259211.helloworld.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.a17259211.helloworld.R
import com.example.a17259211.helloworld.viewmodel.CadastroViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {



    val viewModel by lazy {
        ViewModelProviders.of(this).get(CadastroViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)









        btnEntrar.setOnClickListener(){

            val nome = edNome.text.toString()
            val email = edEmail.text.toString()
            var senha = edSenha.text.toString()

            val ERRO_NOME = "Nome deve ter no minímo 3 caracteres"
            val ERRO_EMAIL = "Email deve conter @"



            if(!validarMinimoCaracteres(nome, 3)){
                edNome.error = ERRO_NOME
            }

            if(!validarTextoComArroba(email)){
                edEmail.error = ERRO_EMAIL
            }

            if(!validarMinimoCaracteres(senha, 3)){
                edSenha.error = "Senha deve conter no minimo 3 caracteres"
            }

            if(!textoContemNumero(senha)){
                edSenha.error = "Senha deve conter pelo menos um numero"
            }

            if(seqNumero(senha)){
                edSenha.error = "Senha não pode ser uma sequência numerica"
            }


            viewModel.cadastrarUsuario()






//            if(nome.length > 3){
//
//                var existeArroba:Boolean = false
//
//                var i:Int = 0;
//                while(i < email.length){
//                    if(email.substring(i, i+1).equals("@")){
//
//                        existeArroba = true
//
//                    }
//                    i++;
//                }
//
//                if (existeArroba){
//
//                    i = 0
//
//                    var seqNumerica:Int = 0
//
//                    var existeNumero:Boolean = false
//
//                    var existeSeqNumerica:Boolean = false
//
//                    var expressao:Regex = "[0-9]".toRegex()
//
//                    while(i < senha.length){
//                        if(senha.substring(i, i+1).matches(expressao)){
//                            existeNumero = true
//                            seqNumerica++
//                        }else{
//                            seqNumerica = 0
//                        }
//
//                        if(seqNumerica >= 3){
//                            existeSeqNumerica = true
//                        }
//                        i++
//                    }
//
//                    if(existeNumero && !existeSeqNumerica && senha.length >= 3){
//                        //mandar para tela que foi cadastrado
//                    }else{
//
//                        edSenha.error = "Senha deve conter no minimo 3 caracteres, não pode conter sequencia numerica, e deve ter pelo menos um caracter"
//                    }
//
//
//
//                }else{
//                    edEmail.error = "Email deve conter @"
//                }
//
//            }else{
//
//                edNome.error = "Nome deve ter no minímo 3 caracteres"
//            }

        }


        viewModel.loading.observe(this, Observer {
            //sempre que acontecer algo na variavel, é notificado
            updateLoading(it)//it é o estado da variavel
        })

    }

    fun updateLoading(loading:Boolean?){


        loading?.let {

            //caso entre nesse bloco significa que a variavel loading não é nula
            if(loading){
                btnEntrar.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }else{
                progressBar.visibility = View.GONE
                btnEntrar.visibility = View.VISIBLE
            }
        }
    }


}
