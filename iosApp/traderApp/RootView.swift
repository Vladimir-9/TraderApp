import SwiftUI
import Shared

struct RootView: View {
    private let root: Root
    
    init(_ root: Root) {
        self.root = root
    }
    
    var body: some View {
        StackView(
            stackValue: StateValue(root.childStack),
            getTitle: { _ in "Trader App" },
            onBack: root.onBackClicked
        ) { child in
            switch child {
                case let child as PortfolioChild: PortfolioView()
                case let child as PositionDetailChild: PositionDetailView()
                default: EmptyView()
            }
        }
    }
}

private typealias PortfolioChild = RootChild.PortfolioChild
private typealias PositionDetailChild = RootChild.PositionDetailChild

//struct RootView_Previews: PreviewProvider {
//    static var previews: some View {
//        RootView(PreviewRootComponent())
//    }
//}

