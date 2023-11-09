plugins {
    kotlin("multiplatform") version "1.9.10"
    id("convention.publication")
}

group = "nl.jacobras"
version = "1.1.2"

repositories {
    mavenCentral()
}

@Suppress("OPT_IN_USAGE")
kotlin {
    targetHierarchy.default()

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js {
        browser()
    }
    jvm {
        jvmToolchain(8)
        withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

// From https://github.com/gradle/gradle/issues/26091#issuecomment-1722947958
tasks.withType<AbstractPublishToMaven>().configureEach {
    val signingTasks = tasks.withType<Sign>()
    mustRunAfter(signingTasks)
}