package br.edu.ifsp.ads.pdm.pedrapapeltesouro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import br.edu.ifsp.ads.pdm.pedrapapeltesouro.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var configActivityLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        //val jogador1: Int = numAletorio.nextInt(0..2)

        configActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
                if (resultado.resultCode == RESULT_OK) {
                    if (resultado.data != null) {
                        val configSalve: Config? =
                            resultado.data?.getParcelableExtra(Intent.EXTRA_USER)
                        if (configSalve?.numeroJogadores != -1) { // insert no banco???

                        } else {
                            //UPDATE no banco???
                        }
                        activityMainBinding.btnPedra.setOnClickListener {
                            jogo(0, configSalve?.numeroJogadores)
                        }

                        activityMainBinding.btnPapel.setOnClickListener {
                            jogo(1, configSalve?.numeroJogadores)
                        }

                        activityMainBinding.btnTesoura.setOnClickListener {
                            jogo(2, configSalve?.numeroJogadores)
                        }
                    }

                }
                activityMainBinding.configBt.setOnClickListener {
                    val configIntent = Intent(this, ConfigActivity::class.java)
                    configActivityLauncher.launch(configIntent)
                }

            }
    }
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.main_menu, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
            R.id.settingsMi -> {
                configActivityLauncher.launch(Intent(this, ConfigActivity::class.java))
                true
            }
            else -> {
                false
            }
        }

        fun jogo(num: Int, numeroJogador: Int?) {
            val numAletorio = Random.nextInt(0..2)

            Log.d("Jogo 1: ", numAletorio.toString())
            when (numAletorio) {
                0 -> activityMainBinding.resultJog1.text = "pedra"
                1 -> activityMainBinding.resultJog1.text = "papel"
                2 -> activityMainBinding.resultJog1.text = "tesoura"
            }
            if (numeroJogador == 2) {
                if (numAletorio == num) {
                    activityMainBinding.resultado.text = "Empatou"

                } else if ((numAletorio == 0 && num == 1) || (numAletorio == 1 && num == 2) || (numAletorio == 2 && num == 0)) {
                    activityMainBinding.resultado.text = "Ganhou"

                } else {
                    activityMainBinding.resultado.text = "Perdeu"

                }
                //return activityMainBinding.resultado
            }
        }

    }

