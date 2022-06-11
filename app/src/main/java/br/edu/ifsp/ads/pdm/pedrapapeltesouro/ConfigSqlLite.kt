package br.edu.ifsp.ads.pdm.pedrapapeltesouro

import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import java.sql.SQLException


class ConfigSqlLite(context: Context): ConfigDAO {
    companion object {
        private val BD_CONFIG="config"
        private val TABELA_CONFIG="config"
        private val COLUNA_ID="id"
        private val NUM_COLUNA_JOGADORES="njogadores"

        val CRIATABELA_TABELAESTMT="CREATE TABLE IF NOT EXISTS ${TABELA_CONFIG} (" +
        "${COLUNA_ID} INTEGER NOT NULL PRIMARY KEY," +
        "${NUM_COLUNA_JOGADORES} INTEGER NOT NULL);"
    }
    private val configBD:SQLiteDatabase
    init {
        configBD = context.openOrCreateDatabase(BD_CONFIG, MODE_PRIVATE, null)
        try {
            configBD.execSQL(CRIATABELA_TABELAESTMT)
        } catch (se: SQLException) {
            Log.e("Config", se.toString())
        }
    }
    override fun insert(config: Config): Long {
        val configCV = ContentValues()
        configCV.put(NUM_COLUNA_JOGADORES, config.numeroJogadores)
        return configBD.insert(TABELA_CONFIG,null,  configCV)
    }

    override fun update(config: Config): Int {
        val configCV = ContentValues()
        configCV.put(NUM_COLUNA_JOGADORES, config.numeroJogadores)
        return configBD.update(TABELA_CONFIG,  configCV, "${COLUNA_ID} = 1", null)
    }

    override fun load(): Config {
        val cursor = configBD.rawQuery("SELECT njogadores FROM config", null)
        return if (cursor.moveToFirst()) {
            with(cursor) {
                Config(getInt(getColumnIndexOrThrow(NUM_COLUNA_JOGADORES)))
            }
        } else {
            Config()
        }
    }


}