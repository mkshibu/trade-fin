package com.example.plugin

import com.example.api.ExampleApi
import com.sun.xml.internal.ws.api.message.Attachment
import net.corda.core.messaging.CordaRPCOps
import net.corda.webserver.services.WebServerPluginRegistry
import java.util.function.Function
import net.corda.core.serialization.CordaSerializable
import net.corda.core.serialization.SerializationWhitelist

/*class ExamplePlugin : SerializationWhitelist    {
    override val whitelist: List<Class<*>>
        get() = listOf(Attachment::class.java)



    /**
     * A list of directories in the resources directory that will be served by Jetty under /web.
     */

}*/
class ExamplePlugin : WebServerPluginRegistry {
    /**
     * A list of classes that expose web APIs.
     */
    override val webApis: List<Function<CordaRPCOps, out Any>> = listOf(Function(::ExampleApi))

    /**
     * A list of directories in the resources directory that will be served by Jetty under /web.
     */
    override val staticServeDirs: Map<String, String> = mapOf(
            // This will serve the exampleWeb directory in resources to /web/example
            "example" to javaClass.classLoader.getResource("exampleWeb").toExternalForm()
    )
}