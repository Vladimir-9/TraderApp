package ru.trader.portfolio.data

import ru.trader.core.model.ErrorResponse
import ru.trader.core.util.orFalse
import ru.trader.core.util.orZero
import ru.trader.core_network.model.ContentDto
import ru.trader.core_network.model.CurrenciesDto
import ru.trader.core_network.model.ErrorResponseDto
import ru.trader.core_network.model.MoneyDto
import ru.trader.core_network.model.PortfolioDataDto
import ru.trader.core_network.model.PortfolioDto
import ru.trader.core_network.model.PositionsDto
import ru.trader.portfolio.domain.model.Content
import ru.trader.portfolio.domain.model.Currencies
import ru.trader.portfolio.domain.model.Money
import ru.trader.portfolio.domain.model.Portfolio
import ru.trader.portfolio.domain.model.PortfolioData
import ru.trader.portfolio.domain.model.Positions
import ru.trader.core.util.Market

internal fun PortfolioDto.toDomain() = Portfolio(
    error = this.error.toDomain(),
    data = this.data.toDomain()
)

private fun ErrorResponseDto?.toDomain() = ErrorResponse(
    code = this?.code.orEmpty(),
    message = this?.message.orEmpty(),
    data = this?.data.orEmpty()
)

private fun PortfolioDataDto?.toDomain() = PortfolioData(
    clientId = this?.clientId.orEmpty(),
    content = this?.content.toDomain(),
    equity = this?.equity.toString(),
    balance = this?.balance.orEmpty(),
    positions = this?.positions?.map { it.toDomain() }.orEmpty(),
    currencies = this?.currencies?.map { it.toDomain() }.orEmpty(),
    money = this?.money?.map { it.toDomain() }.orEmpty()
)

private fun ContentDto?.toDomain() = Content(
    includeCurrencies = this?.includeCurrencies.orFalse(),
    includeMoney = this?.includeMoney.orFalse(),
    includePositions = this?.includePositions.orFalse(),
    includeMaxBuySell = this?.includeMaxBuySell.orFalse()
)

private fun PositionsDto?.toDomain() = Positions(
    securityCode = this?.securityCode.orEmpty(),
    market = Market.getMarket(this?.market),
    balance = this?.balance.orZero(),
    currentPrice = this?.currentPrice.orZero(),
    equity = this?.equity.orZero(),
    averagePrice = this?.averagePrice.orZero(),
    currency = this?.currency.orEmpty(),
    accumulatedProfit = this?.accumulatedProfit.orZero(),
    todayProfit = this?.todayProfit.orZero(),
    unrealizedProfit = this?.unrealizedProfit.orZero(),
    profit = this?.profit.orZero(),
    maxBuy = this?.maxBuy.orZero(),
    maxSell = this?.maxSell.orZero(),
    priceCurrency = this?.priceCurrency.orEmpty(),
    averagePriceCurrency = this?.averagePriceCurrency.orEmpty(),
    averageRate = this?.averageRate.orZero()
)

private fun CurrenciesDto?.toDomain() = Currencies(
    name = this?.name.orEmpty(),
    balance = this?.balance.orZero(),
    crossRate = this?.crossRate.orZero(),
    equity = this?.equity.orZero(),
    unrealizedProfit = this?.unrealizedProfit.orZero()
)

private fun MoneyDto?.toDomain() = Money(
    market = Market.getMarket(this?.market),
    currency = this?.currency.orEmpty(),
    balance = this?.balance.orZero()
)