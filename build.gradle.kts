import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    java
    id("org.jetbrains.dokka") version "1.9.10" // Укажите актуальную версию Dokka
}

group = "academy.kt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    implementation("junit:junit:4.13.1")
    implementation(kotlin("test"))
    implementation("io.mockk:mockk:1.12.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

tasks.dokkaHtml.configure {
    outputDirectory.set(file("docs"))

    // Настраиваем параметры документации
    dokkaSourceSets {
        named("main") {
            suppressInheritedMembers = false
            includeNonPublic = false
        }
    }
}

