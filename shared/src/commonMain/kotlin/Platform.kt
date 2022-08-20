package org.sample.application

expect val platform: String

class Greeting {
    fun greeting() = "Hello, $platform!"
}