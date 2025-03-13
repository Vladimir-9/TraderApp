//
//  Untitled.swift
//  traderApp
//
//  Created by Vladimir Vova on 13.03.2025.
//

import SwiftUI
import Shared 

@propertyWrapper struct StateValue<T : AnyObject>: DynamicProperty {
    @ObservedObject
    private var obj: ObservableValue<T>

    var wrappedValue: T { obj.value }

    init(_ value: Value<T>) {
        obj = ObservableValue(value)
    }
}
