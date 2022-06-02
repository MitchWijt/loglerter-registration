package registration.loglerter

import io.micronaut.function.aws.MicronautRequestHandler

class FunctionRequestHandler(val mapper: JsonMapper) : MicronautRequestHandler<String, LogLerterRegistrationResponse>() {
    override fun execute(jsonString: String): LogLerterRegistrationResponse {
        val configuration: LogLerterConfiguration = mapper.mapJSon(jsonString)
        val registrationService = RegistrationService(configuration)

        // We check if the user exists.
        // if the user exists we call an update function in the registrationService
        // if the user does not exist we call the creation method in the registration service

        // we need to test all the individual units apart from each other.

        return LogLerterRegistrationResponse("")
    }
}

data class LogLerterRegistrationResponse(
    val apiKey: String
)
