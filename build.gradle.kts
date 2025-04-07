plugins {
    kotlin("jvm") version "2.1.10"
}

group = "br.com.learning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.1.20")

    testImplementation(kotlin("test"))
    testImplementation ("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation ("org.amshove.kluent:kluent:1.68")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}