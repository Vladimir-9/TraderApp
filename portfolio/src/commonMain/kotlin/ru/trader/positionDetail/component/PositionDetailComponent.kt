package ru.trader.positionDetail.component

import com.arkivanov.decompose.value.Value
import ru.trader.positionDetail.data.model.PositionDetailViewState

interface PositionDetailComponent {

    val viewState: Value<PositionDetailViewState>
}