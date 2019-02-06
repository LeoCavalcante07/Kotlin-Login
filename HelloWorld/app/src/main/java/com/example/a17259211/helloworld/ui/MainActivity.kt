package com.example.a17259211.helloworld.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.a17259211.helloworld.R
import com.example.a17259211.helloworld.model.Usuario
import com.example.a17259211.helloworld.viewmodel.CadastroViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {



    private var errorSnack: Snackbar? = null

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





        if(validarFormulario(nome, email, senha)){
            viewModel.cadastrarUsuario(
                    Usuario(nome, email, senha)
            )
        }


            //viewModel.cadastrarUsuario()



        }


        viewModel.loading.observe(this, Observer {
            //sempre que acontecer algo na variavel, é notificado
            updateLoading(it)//it é o estado da variavel
        })

        viewModel.error.observe(this, Observer {

            updateError(it)
        })

    }

    fun validarFormulario(nome:String, email:String, senha:String) : Boolean{

        var retorno = true

        val ERRO_NOME = "Nome deve ter no minímo 3 caracteres"
        val ERRO_EMAIL = "Email deve conter @"

        if(!validarMinimoCaracteres(nome, 3)){
            edNome.error = ERRO_NOME
            retorno = false
        }

        if(!validarTextoComArroba(email)){
            edEmail.error = ERRO_EMAIL
            retorno = false
        }

        if(!validarMinimoCaracteres(senha, 3)){
            edSenha.error = "Senha deve conter no minimo 3 caracteres"
            retorno = false
        }

        if(!textoContemNumero(senha)){
            edSenha.error = "Senha deve conter pelo menos um numero"
            retorno= false
        }

        if(seqNumero(senha)){
            edSenha.error = "Senha não pode ser uma sequência numerica"
            retorno =false
        }

        return retorno

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

    fun updateError(error: Boolean?){//interrogação significa que a variavel pode ser nula

        error?.let {
            //caso entre nesse bloco significa que a variavel loading não é nula

            if(error){
                errorSnack = Snackbar.make(rootView, "Erro de conexão", Snackbar.LENGTH_INDEFINITE).apply {
                    setAction("Reconectar", object: View.OnClickListener{
                        override fun onClick(v: View?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            viewModel.cadastrarUsuario(getUsuario())

                        }

                    })
                    show()
                }

                progressBar.visibility = View.GONE
                btnEntrar.visibility = View.VISIBLE

            }

        }
    }

    fun getUsuario():Usuario{

        val nome = edNome.text.toString()
        val email = edEmail.text.toString()
        var senha = edSenha.text.toString()

        return Usuario(nome, email, senha)
    }


}
