class Solution {
    fun numUniqueEmails(emails: Array<String>): Int {
        val unique = HashSet<String>()

        for (e in emails) {
            val parts = e.split("@")
            var local = parts[0]
            val domain = parts[1]

            local = local.split("+")[0]
            local = local.replace(".", "")
            unique.add("$local@$domain")
        }
        return unique.size
    }
}