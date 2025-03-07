package ru.trader.portfolio.component

import com.arkivanov.decompose.value.Value
import ru.trader.portfolio.data.model.PortfolioViewState
import ru.trader.portfolio.domain.model.Position

interface PortfolioComponent {

    val state: Value<PortfolioViewState>

    fun onClickPosition(position: Position)
}