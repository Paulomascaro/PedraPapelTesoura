package br.edu.ifsp.ads.pdm.pedrapapeltesouro

class ConfigController(mainActivity: MainActivity) {
    val configDAO: ConfigDAO = ConfigSqlLite(mainActivity)
    fun insert(config: Config) = configDAO.insert(config)
    fun update(config: Config) = configDAO.update(config)
    fun load(): Config = configDAO.load()


}