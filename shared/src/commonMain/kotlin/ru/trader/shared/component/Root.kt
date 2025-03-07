package ru.trader.shared.component

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.trader.positionDetail.component.PositionDetailComponentImpl
import ru.trader.portfolio.component.PortfolioComponentImpl

interface Root {
    val childStack: Value<ChildStack<*, Child>>

    val childSlot: Value<ChildSlot<*, SlotChild>>

    fun dismissSlotChild()

    sealed class SlotChild {
        class PortfolioChild(val component: PortfolioComponentImpl) : SlotChild()
    }

    fun onBackClicked()

    sealed class Child {
        class PortfolioChild(val component: PortfolioComponentImpl) : Child()
        class PositionDetailChild(val component: PositionDetailComponentImpl) : Child()
    }
}