val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.serialization") version "1.5.20"
}
group = "me.asinghi"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    implementation("com.h2database:h2:1.4.191")

    implementation ("org.jetbrains.exposed:exposed-core:0.33.1")
    implementation ("org.jetbrains.exposed:exposed-jdbc:0.33.1")
    implementation ("org.jetbrains.exposed:exposed-dao:0.33.1")
    implementation ("com.zaxxer:HikariCP:3.4.2")
}