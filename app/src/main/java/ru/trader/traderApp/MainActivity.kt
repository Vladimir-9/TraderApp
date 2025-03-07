package ru.trader.traderApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import ru.trader.shared.component.Root
import ru.trader.shared.component.RootComponent
import ru.trader.traderApp.screen.PortfolioScreen
import ru.trader.traderApp.screen.PositionDetailScreen
import ru.trader.traderApp.ui.theme.TraderAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
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
