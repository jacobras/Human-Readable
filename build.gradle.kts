plugins {
    kotlin("multiplatform") version "1.9.10"
}

group = "nl.jacobras"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

@Suppress("OPT_IN_USAGE")
kotlin {
    targetHierarchy.default()

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