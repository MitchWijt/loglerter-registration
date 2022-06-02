package registration.loglerter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class JsonMapper {
    inline fun <reified T> mapJSon(jsonString: String): T {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(jsonString)
    }
}