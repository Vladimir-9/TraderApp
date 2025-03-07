package ru.trader.positionDetail

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.trader.core.SharedViewModel
import ru.trader.positionDetail.data.model.PositionDetailViewState
import ru.trader.portfolio.domain.model.Position

class PositionDetailViewModel(position: Position) : SharedViewModel() {

    private val _state = MutableValue(PositionDetailViewState(position))
    val state: Value<PositionDetailViewState> = _state
}