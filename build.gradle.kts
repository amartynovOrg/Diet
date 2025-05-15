plugins {
    id("java")
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.hibernate:hibernate-validator:8.0.2.Final")
    implementation("javax.inject:javax.inject:1")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
sourceSets {
    val functionalTest by creating {
        compileClasspath += sourceSets["main"].output + sourceSets["test"].output
        runtimeClasspath += sourceSets["main"].output + sourceSets["test"].output
        java.srcDir(file("src/functionalTest/java"))
        resources.srcDir(file("src/functionalTest/resources"))
    }
}

configurations {
    val functionalTestImplementation by getting {
        extendsFrom(configurations["testImplementation"])
    }
    val functionalTestRuntimeOnly by getting {
        extendsFrom(configurations["testRuntimeOnly"])
    }
}

tasks.register<Test>("functionalTest") {
    description = "Runs functional tests."
    group = "verification"
    testClassesDirs = sourceSets["functionalTest"].output.classesDirs
    classpath = sourceSets["functionalTest"].runtimeClasspath
    shouldRunAfter("test")
}

tasks.named("check") {
    dependsOn("functionalTest")
}

tasks.test {
        useJUnitPlatform()
    }
