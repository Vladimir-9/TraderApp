package ru.trader.traderApp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ru.trader.portfolio.component.PortfolioComponent
import ru.trader.portfolio.domain.model.Position

@Composable
fun PortfolioScreen(component: PortfolioComponent) {

    val model by component.state.subscribeAsState()

    when {
        model.loading -> Loader()
        model.portfolio.data.positions.isEmpty() -> PositionsEmpty()
        else -> PositionsList(
            positions = model.portfolio.data.positions,
            onClickPosition = component::onClickPosition,
        )
    }
}

@Composable
private fun PositionsList(positions: List<Position>, onClickPosition: (Position) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(positions) {
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

@Composable
private fun Loader() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun PositionsEmpty() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Список пуст", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Text(text = "У вас пока нет позиций")
    }
}