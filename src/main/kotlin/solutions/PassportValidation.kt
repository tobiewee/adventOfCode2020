package solutions

data class PassportValidation(
    var byr: Boolean = false,
    var iyr: Boolean = false,
    var eyr: Boolean = false,
    var hgt: Boolean = false,
    var hcl: Boolean = false,
    var ecl: Boolean = false,
    var pid: Boolean = false,
    var cid: Boolean = true //Optional for now
) {
    fun validatePairDetails(fieldValueMapping: Pair<String, String>) {
        TODO("To be implemented.")
    }

    fun validatePairFields(fieldValueMapping: Pair<String, String>) {
        when (fieldValueMapping.first) {
            "byr" -> this.byr = true
            "iyr" -> this.iyr = true
            "eyr" -> this.eyr = true
            "hgt" -> this.hgt = true
            "hcl" -> this.hcl = true
            "ecl" -> this.ecl = true
            "pid" -> this.pid = true
            "cid" -> this.cid = true
            else -> return
        }
    }

    fun isValid(): Boolean {
        return cid && pid && ecl && hcl && hgt && eyr && iyr && byr
    }
}