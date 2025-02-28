package ru.trader.core_database.database

class Database(databaseDriverFactory: DatabaseDriverFactory) {

    private val database = TraderDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.traderDatabaseQueries

    fun getIdUser(): String = dbQuery.selectId().executeAsOne()

    fun createUserId(id: String) {
        dbQuery.transaction {
            dbQuery.removeAllId()
            dbQuery.insertLaunch(id)
        }
    }
}