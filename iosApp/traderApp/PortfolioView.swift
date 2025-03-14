import SwiftUI
import Shared

internal struct PortfolioView: View {
    
    private let component: PortfolioComponent
    
    @StateValue
    private var state: PortfolioViewState

    init(_ component: PortfolioComponent) {
        self.component = component
        _state = StateValue(component.state)
    }
    
    var body: some View {
        if (state.loading) { PortfolioLoadingView() }
        else if (state.error) { PortfolioErrorView() }
        else if (state.portfolio.data.positions.isEmpty) { PortfolioEmptyView() }
        else { content(data: state.portfolio.data) }
    }
    
    @ViewBuilder
    func content(data: PortfolioData) -> some View {
        List(data.positions, id: \.self) { position in
            PositionCardView(position: position) { clickedPosition in
                component.onClickPosition(position: clickedPosition)
            }
        }
    }
}

private struct PositionCardView: View {
    let position: Position
    let onClickPosition: (Position) -> Void

    var body: some View {
        Button(action: {
            onClickPosition(position)
        }) {
            VStack {
                Text("\(position.currentPrice)")
                    .font(.body)
            }
            .frame(maxWidth: .infinity, minHeight: 70)
            .cornerRadius(8)
            .padding(.vertical, 6)
        }
        .buttonStyle(PlainButtonStyle())
    }
}

private struct PortfolioLoadingView: View {
    var body: some View {
        Text("LoadingView")
    }
}

private struct PortfolioErrorView: View {
    var body: some View {
        Text("ErrorView")
    }
}

private struct PortfolioEmptyView: View {
    var body: some View {
        VStack {
            Text("Список пуст")
                .font(.title)
            Text("У вас пока нет позиций")
        }
    }
}
