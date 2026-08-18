plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Appium
    implementation("io.appium:java-client:10.1.1")

    // Selenium
    implementation("org.seleniumhq.selenium:selenium-java:4.43.0")

    // TestNG
    implementation("org.testng:testng:7.11.0")

    // Other dependencies
    implementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    implementation("org.slf4j:slf4j-simple:2.0.17")
    implementation("io.rest-assured:rest-assured:5.5.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")

    // JUnit - keep only if you need JUnit elsewhere
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useTestNG()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}