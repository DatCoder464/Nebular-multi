package net.examplemod

import dev.architectury.injectables.annotations.ExpectPlatform

object ExampleExpectPlatform {

    @ExpectPlatform
    @JvmStatic
    fun platformName(): String {
        // Just throw an error, the content should get replaced at runtime.
        throw AssertionError()
    }

}