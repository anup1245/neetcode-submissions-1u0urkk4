class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) {
            return false
        }

        val set = HashMap<Char,Int>()

        for(c in s) {
            set[c] = set.getOrPut(c, {0}) + 1
        }
        
        for(c in t) {
            if(set.containsKey(c)) {
                set[c] = set.getOrPut(c, {0}) - 1
                if(set[c] == 0) {
                   set.remove(c) 
                }
            } else {
                return false
            }
            
        }

        return set.isEmpty()

    }
}
