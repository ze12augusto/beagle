// This file was generated from JSON Schema using quicktype, do not modify it directly.
// To parse the JSON, add this file to your project and do:
//
//   let button = try Button(json)

import Foundation

// MARK: - Button
class Button {
    let name: String
    let onPress: Double
    let styleID: String?

    init(name: String, onPress: Double, styleID: String?) {
        self.name = name
        self.onPress = onPress
        self.styleID = styleID
    }
}
