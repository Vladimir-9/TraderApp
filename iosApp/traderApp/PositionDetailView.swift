import SwiftUI
import Shared

internal struct PositionDetailView: View {
    
    private let component: PositionDetailComponent
    
    @StateValue
    private var state: PositionDetailViewState

    init(_ component: PositionDetailComponent) {
        self.component = component
        _state = StateValue(component.state)
    }
    
    var body: some View {
        Text("\(state.position.currentPrice)")
    }
}
