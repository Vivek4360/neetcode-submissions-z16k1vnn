class MyHashSet() {
    private val data = mutableListOf<Int>()

    fun add(key: Int) {
        if (!contains(key)) {
            data.add(key)
        }
    }

    fun remove(key: Int) {
        data.remove(key)
    }

    fun contains(key: Int): Boolean {
        return data.contains(key)
    }
}