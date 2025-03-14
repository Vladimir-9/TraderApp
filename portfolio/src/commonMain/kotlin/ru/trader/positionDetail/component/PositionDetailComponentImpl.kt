package ru.trader.positionDetail.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import org.koin.core.parameter.ParametersHolder
import ru.trader.core.util.getOrCreateViewModel
import ru.trader.positionDetail.PositionDetailViewModel
import ru.trader.positionDetail.data.model.PositionDetailViewState
import ru.trader.portfolio.domain.model.Position

class PositionDetailComponentImpl(
    componentContext: ComponentContext,
    position: Position
) : PositionDetailComponent, ComponentContext by componentContext {

    private val viewModel: PositionDetailViewModel = getOrCreateViewModel {
        ParametersHolder(mutableListOf(position))
    }

    override val state: Value<PositionDetailViewState> = viewModel.state

}