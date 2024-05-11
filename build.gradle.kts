import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("com.vanniktech.maven.publish") version "0.28.0"
    id("io.github.skeptick.libres") version "1.2.3-beta02"
}

group = "nl.jacobras"
version = "1.7.0"

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01, true)
    signAllPublications()

    @Suppress("UnstableApiUsage")
    pom {
        name.set("Human Readable")
        description.set("A small set of data formatting utilities for Kotlin Multiplatform (KMP)")
        url.set("https://github.com/jacobras/human-readable")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("jacobras")
                name.set("Jacob Ras")
                email.set("info@jacobras.nl")
            }
        }
        scm {
            url.set("https://github.com/jacobras/human-readable")
        }
    }
}

repositories {
    mavenCentral()
}

kotlin {
    applyDefaultHierarchyTemplate()

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }
    wasmJs {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                }
            }
        }
    }
    jvm {
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
                implementation(libs.kotlinX.datetime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.assertK)
            }
        }
        val wasmJsMain by getting
        val appleAndJsMain by creating {
            dependsOn(commonMain)
            appleMain.get().dependsOn(this)
            jsMain.get().dependsOn(this)
            wasmJsMain.dependsOn(this)
        }
    }
}

// From https://github.com/gradle/gradle/issues/26091#issuecomment-1722947958
tasks.withType<AbstractPublishToMaven>().configureEach {
    val signingTasks = tasks.withType<Sign>()
    mustRunAfter(signingTasks)
}