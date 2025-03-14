import SwiftUI
import Shared

@main
struct TraderApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    init() {
        PlatformSDK().doInit(configuration: Core_databasePlatformConfiguration())
    }
     
    var body: some Scene {
        
        WindowGroup {
            RootView(appDelegate.root)
        }
    }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    let root: RootComponent = RootComponent(
        componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle())
    )
}
