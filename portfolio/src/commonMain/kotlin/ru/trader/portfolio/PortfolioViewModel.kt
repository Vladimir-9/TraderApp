package ru.trader.portfolio

import TraderApp.portfolio.BuildConfig
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.launch
import ru.trader.core.SharedViewModel
import ru.trader.core.util.Resource
import ru.trader.portfolio.data.model.PortfolioViewState
import ru.trader.portfolio.domain.PortfolioRepository

class PortfolioViewModel(private val repository: PortfolioRepository) : SharedViewModel() {

    private val _state = MutableValue(PortfolioViewState())
    val state: Value<PortfolioViewState> = _state

    init {
        coroutineScope.launch {

            when (val res = repository.getPortfolio(BuildConfig.CLIENT_ID)) {

                is Resource.Failure -> Unit

                is Resource.Success -> _state.value =
                    _state.value.copy(loading = false, portfolio = res.value)
            }
        }
    }
}