package ru.trader.portfolio.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.trader.portfolio.PortfolioViewModel
import ru.trader.portfolio.data.PortfolioRepositoryImpl
import ru.trader.portfolio.domain.PortfolioRepository

val portfolioModule = module {
    singleOf(::PortfolioRepositoryImpl) bind PortfolioRepository::class
    factory { PortfolioViewModel(get()) }
}