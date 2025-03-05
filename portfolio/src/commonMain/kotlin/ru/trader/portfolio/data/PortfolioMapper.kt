package ru.trader.portfolio.data

import ru.trader.core.EMPTY_STRING
import ru.trader.core.model.ErrorResponse
import ru.trader.core.util.Market
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

internal fun PortfolioDto.toDomain() = Portfolio(
    error = error?.toDomain() ?: ErrorResponse(),
    data = data?.toDomain() ?: PortfolioData(),
)

private fun ErrorResponseDto.toDomain() = ErrorResponse(
    code = code ?: EMPTY_STRING,
    message = message ?: EMPTY_STRING,
    data = data ?: EMPTY_STRING,
)

private fun PortfolioDataDto.toDomain() = PortfolioData(
    clientId = clientId,
    content = content.toDomain(),
    equity = equity.toString(),
    balance = balance,
    positions = positions.map { it.toDomain() },
    currencies = currencies.map { it.toDomain() },
    money = money.map { it.toDomain() },
)

private fun ContentDto.toDomain() = Content(
    includeCurrencies = includeCurrencies,
    includeMoney = includeMoney,
    includePositions = includePositions,
    includeMaxBuySell = includeMaxBuySell,
)

private fun PositionsDto.toDomain() = Positions(
    securityCode = securityCode,
    market = Market.getMarket(market),
    balance = balance,
    currentPrice = currentPrice,
    equity = equity,
    averagePrice = averagePrice,
    currency = currency,
    accumulatedProfit = accumulatedProfit,
    todayProfit = todayProfit,
    unrealizedProfit = unrealizedProfit,
    profit = profit,
    maxBuy = maxBuy,
    maxSell = maxSell,
    priceCurrency = priceCurrency,
    averagePriceCurrency = averagePriceCurrency,
    averageRate = averageRate,
)

private fun CurrenciesDto.toDomain() = Currencies(
    name = name,
    balance = balance,
    crossRate = crossRate,
    equity = equity,
    unrealizedProfit = unrealizedProfit,
)

private fun MoneyDto.toDomain() = Money(
    market = Market.getMarket(market),
    currency = currency,
    balance = balance,
)