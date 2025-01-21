class Solution(object):
    def countBits(self, n):
        ans=[]
        for i in range (n+1):
            ans.append(bin(i).count('1'))
        return ans

        