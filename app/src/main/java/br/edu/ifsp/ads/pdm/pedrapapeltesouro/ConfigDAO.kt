package br.edu.ifsp.ads.pdm.pedrapapeltesouro

interface ConfigDAO {

    fun insert(config: Config): Long
    fun update(config: Config): Int
    fun load(): Config

}