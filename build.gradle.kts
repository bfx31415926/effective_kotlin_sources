import org.gradle.kotlin.dsl.kapt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.10"
    kotlin("kapt") version "2.0.10"
    java
    id("org.jetbrains.dokka") version "1.9.20"
    id("me.champeau.jmh") version "0.7.1"
}

group = "academy.kt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
    implementation("junit:junit:4.13.2")                                   // ← JUnit 4
    implementation("org.jetbrains.kotlin:kotlin-test-junit:2.0.10")       // ← Kotlin + JUnit 4
    implementation("io.mockk:mockk:1.13.8")

    implementation("org.openjdk.jmh:jmh-core:1.36")
    kapt("org.openjdk.jmh:jmh-generator-annprocess:1.36")
}

tasks.test {
    useJUnit() // ← важно для JUnit 4
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.dokkaHtml {
    outputDirectory.set(file("docs"))
    moduleName.set("effective-kotlin")
}