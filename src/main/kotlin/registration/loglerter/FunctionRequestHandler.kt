package registration.loglerter

import io.micronaut.function.aws.MicronautRequestHandler

class FunctionRequestHandler(val mapper: JsonMapper) : MicronautRequestHandler<String, LogLerterRegistrationResponse>() {
    override fun execute(jsonString: String): LogLerterRegistrationResponse {
        val configuration: LogLerterConfiguration = mapper.mapJSon(jsonString)
        val registrationService = RegistrationService(configuration)

        return LogLerterRegistrationResponse("")
    }
}

data class LogLerterRegistrationResponse(
    val apiKey: String
)
