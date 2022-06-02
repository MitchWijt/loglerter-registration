package registration.loglerter

data class LogLerterConfiguration(
    val username: String,
    val rules: List<Rule>
)

data class Rule(
    val severity: String,
    val alertChannel: String
)