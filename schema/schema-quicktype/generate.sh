#swift
quicktype ./Models/button.ts --lang swift --just-types --initializers --swift-5-support --struct-or-class class -o Generated/Swift/button.swift

#kotlin
quicktype ./Models/button.ts --lang kotlin --framework just-types -o Generated/Kotlin/button.kt