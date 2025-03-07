package ru.trader.traderApp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.trader.portfolio.component.PortfolioComponent
import ru.trader.portfolio.domain.model.Position

@Composable
fun PortfolioScreen(component: PortfolioComponent) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val model by component.state.subscribeAsState()

        PositionsList(model.portfolio?.data?.positions, component::onClickPosition)
    }
}

@Composable
private fun PositionsList(positions: List<Position>?, onClickPosition: (Position) -> Unit) {
    LazyColumn {
        items(positions.orEmpty()) {
            ItemPosition(it, onClickPosition)
        }
    }
}

@Composable
private fun ItemPosition(position: Position, onClickPosition: (Position) -> Unit) {

    Card(
        modifier = Modifier
            .background(Color.Gray)
            .padding(vertical = 6.dp),
        onClick = {
            onClickPosition(position)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(position.currentPrice.toString())
        }
    }
}