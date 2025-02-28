import SwiftUI
import ComposeApp

@main
struct TraderApp: App {
    
    init() {
        PlatformSDK().doInit(configuration: Core_databasePlatformConfiguration())
    }
     
    var body: some Scene {
        
        WindowGroup {
            ContentView()
        }
    }
}
