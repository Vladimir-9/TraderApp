package ru.trader.positionDetail.di

import org.koin.dsl.module
import ru.trader.positionDetail.PositionDetailViewModel

val detailPositionModule = module {
    factory {
        PositionDetailViewModel(get())
    }
}