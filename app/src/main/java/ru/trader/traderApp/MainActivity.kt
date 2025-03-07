package ru.trader.traderApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.trader.portfolio.component.PortfolioComponent
import ru.trader.shared.component.Root
import ru.trader.shared.component.RootComponent
import ru.trader.traderApp.screen.PortfolioScreen
import ru.trader.traderApp.screen.PositionDetailScreen
import ru.trader.traderApp.ui.theme.TraderAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val root = RootComponent(componentContext = defaultComponentContext())

        setContent {
            TraderAppTheme {
                RootContent(root)
            }
        }
    }
}

@Composable
private fun RootContent(component: Root) {
    Children(
        stack = component.childStack,
        animation = stackAnimation(fade()),
    ) {
        when (val child = it.instance) {
            is Root.Child.PortfolioChild -> PortfolioScreen(child.component)
            is Root.Child.PositionDetailChild -> PositionDetailScreen(child.component)
        }
    }
}
