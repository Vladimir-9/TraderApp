package ru.trader.portfolio.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import org.koin.core.component.KoinComponent
import ru.trader.core.util.getOrCreateViewModel
import ru.trader.portfolio.PortfolioViewModel
import ru.trader.portfolio.data.model.PortfolioViewState
import ru.trader.portfolio.domain.model.Position

class PortfolioComponentImpl(
    componentContext: ComponentContext,
    private val onPositionSelected: (position: Position) -> Unit
) : PortfolioComponent, ComponentContext by componentContext, KoinComponent {

    private val viewModel: PortfolioViewModel = getOrCreateViewModel()

    override val state: Value<PortfolioViewState> = viewModel.state

    override fun onClickPosition(position: Position) {
        onPositionSelected(position)
    }
}