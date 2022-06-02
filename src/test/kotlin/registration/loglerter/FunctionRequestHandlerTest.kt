package registration.loglerter

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify

class FunctionRequestHandlerTest : DescribeSpec({
    val jsonMapper = spyk(JsonMapper())

    describe("FunctionRequestHandler") {
        it("should accept a valid JSON string as input and return a API key as string") {
            val jsonString = """{"username":"1234test","rules":[{"severity":"alert","alertChannel":"slack"}]}"""

            val handler = FunctionRequestHandler(jsonMapper)
            val result = handler.execute(jsonString)

            result shouldBe LogLerterRegistrationResponse("")
        }


        // this test does not work yet. I am not sure why this is not working yet. Have to figure out.
        it("should accept a valid JSON string and convert the JSON string to a model") {
            val jsonString = """{"username":"1234test","rules":[{"severity":"alert","alertChannel":"slack"}]}"""

            val handler = FunctionRequestHandler(jsonMapper)
            handler.execute(jsonString)

            every { jsonMapper.mapJSon<LogLerterConfiguration>(jsonString) } returns LogLerterConfiguration("1234test", listOf(Rule("alert", "slack")))
        }
    }
})

