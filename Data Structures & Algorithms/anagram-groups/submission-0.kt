class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
       val map = HashMap<String, ArrayList<String>>()

       for(str in strs) {
            val temp = String(str.toCharArray().also { it.sort() })
            map.getOrPut(temp,{ArrayList<String>()}).add(str)
       } 
       return map.values.toList()

    }
}
