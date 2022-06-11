package br.edu.ifsp.ads.pdm.pedrapapeltesouro

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.ads.pdm.pedrapapeltesouro.databinding.ActivityConfigBinding
import br.edu.ifsp.ads.pdm.pedrapapeltesouro.databinding.ActivityMainBinding

class ConfigActivity: AppCompatActivity() {
        private lateinit var configBinding: ActivityConfigBinding

        object Constantes {
            val CONFIGURACOES_ARQUIVO = "configuracoes"
            val NUMERO_JOGADORES_ATRIBUTO = "jogadores"

        }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            configBinding= ActivityConfigBinding.inflate(layoutInflater)
            setContentView(configBinding.root)

            configBinding.configBt.setOnClickListener {

                val numeroJogadores: Int = (configBinding.numJogadores).text.toString().toInt()
                val config = Config(numeroJogadores)
                val retornoIntent = Intent()
                retornoIntent.putExtra(Intent.EXTRA_USER, config)
                setResult(RESULT_OK, retornoIntent)
                finish()
            }
        }
    }

            /*configBinding.salvarBt.setOnClickListener {
                val numeroDados:Int = (configBinding.numJogadoresSp.selectedView as TextView).text.toString().toInt()
                val configuracao = Configuracao(numeroDados)
                val retornoIntent = Intent()
                retornoIntent.putExtra(Intent.EXTRA_USER, configuracao)
                setResult(RESULT_OK, retornoIntent)
                finish()
            }*/


