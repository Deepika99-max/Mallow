plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testImplementation("org.seleniumhq.selenium:selenium-java:4.23.1")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    testImplementation("org.testng:testng:7.10.2")
    testImplementation("org.slf4j:slf4j-simple:2.0.17")
    testImplementation("io.appium:java-client:10.1.1")
    testImplementation("io.rest-assured:rest-assured:5.5.0")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
}

tasks.test {
    useJUnitPlatform()
}