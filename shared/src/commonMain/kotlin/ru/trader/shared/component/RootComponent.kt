package ru.trader.shared.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DelicateDecomposeApi
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.trader.portfolio.component.PortfolioComponentImpl
import ru.trader.portfolio.domain.model.Position
import ru.trader.positionDetail.component.PositionDetailComponentImpl

class RootComponent(
    componentContext: ComponentContext
) : Root, ComponentContext by componentContext {

    private val navigation = StackNavigation<ScreenConfig>()

    override val childStack: Value<ChildStack<*, Root.Child>> = childStack(
        source = navigation,
        serializer = ScreenConfig.serializer(),
        handleBackButton = true,
        initialStack = { listOf(ScreenConfig.Portfolio) },
        childFactory = ::child,
    )

    private val slotNavigation = SlotNavigation<SlotConfig>()

    override val childSlot: Value<ChildSlot<*, Root.SlotChild>> = childSlot(
        source = slotNavigation,
        serializer = SlotConfig.serializer(),
        handleBackButton = true,
        childFactory = ::child
    )

    override fun dismissSlotChild() {
        slotNavigation.dismiss()
    }

    override fun onBackClicked() {
        navigation.pop()
    }


    private fun child(
        config: ScreenConfig,
        componentContext: ComponentContext
    ): Root.Child {
        return when (config) {

            is ScreenConfig.Portfolio -> getPortfolioChild(componentContext)

            is ScreenConfig.PositionDetails -> getPositionChild(componentContext, config.position)
        }
    }

    @OptIn(DelicateDecomposeApi::class)
    private fun getPortfolioChild(componentContext: ComponentContext): Root.Child.PortfolioChild {

        val portfolioComponent = PortfolioComponentImpl(componentContext) { position ->
            navigation.push(
                ScreenConfig.PositionDetails(
                    position
                )
            )
        }
        return Root.Child.PortfolioChild(portfolioComponent)
    }

    private fun getPositionChild(
        componentContext: ComponentContext,
        position: Position
    ): Root.Child.PositionDetailChild {

        return Root.Child.PositionDetailChild(
            PositionDetailComponentImpl(componentContext, position)
        )
    }

    private fun child(
        config: SlotConfig,
        componentContext: ComponentContext
    ): Root.SlotChild {
        return when (config) {
            is SlotConfig.Settings -> {
                Root.SlotChild.PortfolioChild(
                    PortfolioComponentImpl(componentContext) { id -> }
                )
            }
        }
    }
}

@Serializable
private sealed interface ScreenConfig {

    @Serializable
    data object Portfolio : ScreenConfig

    @Serializable
    data class PositionDetails(val position: Position) : ScreenConfig
}

@Serializable
sealed interface SlotConfig {
    @Serializable
    data object Settings : SlotConfig
}