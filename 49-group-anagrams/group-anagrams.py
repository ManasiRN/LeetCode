class Solution(object):
    def groupAnagrams(self, strs):
        anagram_groups = {}

        for word in strs:
            sorted_word = ''.join(sorted(word))

            if sorted_word not in anagram_groups:
                anagram_groups[sorted_word] = []
            anagram_groups[sorted_word].append(word)

        return list(anagram_groups.values())        
        