plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // compileOnly
    compileOnly("org.springframework:spring-core:6.0.8")
    // jetbrains annotations
    implementation("org.jetbrains:annotations:24.0.1")
    // test
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
