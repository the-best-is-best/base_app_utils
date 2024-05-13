plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("dev.icerock.mobile.multiplatform-resources")
    id("maven-publish")
    id("signing")
}


apply(plugin = "maven-publish")
apply(plugin = "signing")




afterEvaluate {
    tasks.withType<PublishToMavenLocal> {
        // Make 'publishReleasePublicationToMavenLocal' depend on 'assembleRelease'
        dependsOn("assembleRelease")
    }
    publishing {

        publications.create<MavenPublication>("release") {
            groupId = "io.github.the-best-is-best"
                artifactId = "base_app_utils"
            version = "1.0.0"
           // from(components["release"])



            //  artifact("$buildDir/outputs/aar/ComposeQuill-release.aar")
            //artifact("$buildDir/libs/ComposeQuill-release.jar")
            // Provide artifacts information required by Maven Central
            pom {
                name.set("BAse App Utils")
                description.set("A set of utilities for KMM and use moko.resources")
                url.set("https://github.com/the-best-is-best/base_app_utils")
                licenses {
                    license {
                        name.set("Apache-2.0")
                        url.set("https://opensource.org/licenses/Apache-2.0")
                    }
                }
                issueManagement {
                    system.set("Github")
                    url.set("https://github.com/the-best-is-best/base_app_utils/issues")
                }
                scm {
                    connection.set("https://github.com/the-best-is-best/base_app_utils.git")
                    url.set("https://github.com/the-best-is-best/base_app_utils")
                }
                developers {
                    developer {
                        id.set("MichelleRaouf")
                        name.set("Michelle Raouf")
                        email.set("eng.michelle.raouf@gmail.com")
                    }
                }
            }
        }
        repositories {
//            maven {
//                name = "OSSRH-snapshots"
//                url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
//                credentials {
//                    username = System.getenv("MAVEN_NAME")
//                    password = System.getenv("MAVEN_TOKEN")
//                }
//            }

//            maven {
//                name = "OSSRH"
//                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
//                credentials {
//                    username = "the-best-is-best"
//                }
//            }
//            maven {
//                name = "LocalMaven"
//                url = uri("$buildDir/maven")
//                   }
//                maven {
//                    name = "GitHubPackages"
//                    url = uri("https://github.com/the-best-is-best/composeSearchableDropDown")
//                    credentials {
//                        username = "the-best-is-best"
//                        password =
//                            System.getenv("BUILD_MAVEN")
//                    }
            //      }
        }
    }

}



signing {
    useGpgCmd()
    sign(publishing.publications)
}
kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.0"
        framework {
            export(libs.icerock.moko.resources)
            export("dev.icerock.moko:graphics:0.9.0") // toUIColor here

            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)

            api(libs.icerock.moko.resources)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.tbib.base_app_utils"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation(libs.androidx.fragment.ktx)
}
