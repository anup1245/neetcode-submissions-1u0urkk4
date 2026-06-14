class TimeMap() {

    val map = HashMap<String,ArrayList<TimeValue>>()

    fun set(key: String, value: String, timestamp: Int) {
        map[key] = map.getOrDefault(key, ArrayList()).also{ it.add(TimeValue(value, timestamp))}
    }

     fun get(key: String, timestamp: Int): String {
        if(!map.containsKey(key)) {
            return ""
        }
        val values = map[key]!!
        var result = ""
        var l = 0
        var r= values.size-1
        while (l<=r) {
            val mid = (l+r)/2
            if (values[mid].time <= timestamp) {
                result = values[mid].value   // candidate, but try for a larger valid timestamp
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return result

    }
}

data class TimeValue(val value: String, val time:Int)
