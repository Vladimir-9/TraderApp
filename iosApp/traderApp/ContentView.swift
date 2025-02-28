import SwiftUI
import ComposeApp

struct ContentView: View {
    
    @State private var showContent = false
    
    var body: some View {
        VStack {
            
            Button("Click me!") {
                withAnimation {
                    showContent = !showContent
                }
            }

            if showContent {
                VStack(spacing: 16) {
                    
                    Image(systemName: "swift")
                        .font(.system(size: 200))
                        .foregroundColor(.accentColor)
                     
                    let id: String = String(describing: KoinHelperForIos().getLaunches())
                    
                    Text("SwiftUI: \(id)")
                }
                .transition(.move(edge: .top).combined(with: .opacity))
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
