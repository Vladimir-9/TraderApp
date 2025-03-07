package ru.trader.portfolio.data.model

import ru.trader.portfolio.domain.model.Portfolio

data class PortfolioViewState(
    val loading: Boolean = true,
    val error: Boolean = false,
    val portfolio: Portfolio = Portfolio(),
)