plugins {
    id("org.jetbrains.intellij") version "0.6.5"
    java
}

group = "com.privitar"
version = "1.1"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2021.1.1"
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes("""
      Add change notes here.<br>
      <em>most HTML tags may be used</em>""")
}
