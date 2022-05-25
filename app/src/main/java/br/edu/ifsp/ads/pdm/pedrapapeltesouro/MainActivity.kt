package br.edu.ifsp.ads.pdm.pedrapapeltesouro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.edu.ifsp.ads.pdm.pedrapapeltesouro.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        //val jogador1: Int = numAletorio.nextInt(0..2)

        fun jogo(num: Int) {
            val numAletorio = Random.nextInt(3)

            Log.d("Jogo 1: ",numAletorio.toString())
            when(numAletorio){
                0 -> activityMainBinding.resultJog1.text = "pedra"
                1 -> activityMainBinding.resultJog1.text = "papel"
                2 -> activityMainBinding.resultJog1.text = "tesoura"
            }
            if(numAletorio == num){
                activityMainBinding.resultado.text = "Empatou"

            }
            else if((numAletorio== 0 && num == 1) || (numAletorio == 1 && num == 2) || (numAletorio == 2 && num == 0)){
                activityMainBinding.resultado.text = "Ganhou"

            }
            else{
                activityMainBinding.resultado.text =  "Perdeu"

            }
            //return activityMainBinding.resultado
        }

        activityMainBinding.btnPedra.setOnClickListener {
            jogo(0)
        }

        activityMainBinding.btnPapel.setOnClickListener {
            jogo(1)
        }

        activityMainBinding.btnTesoura.setOnClickListener {
            jogo(2)
        }

    }





}