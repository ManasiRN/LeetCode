class Solution(object):
    def insert(self, intervals, newInterval):
        result = []
        i = 0
        n = len(intervals)

        # Phase 1: Add all intervals that end before new interval starts
        while i < n and intervals[i][1] < newInterval[0]:
            result.append(intervals[i])
            i += 1

        # Phase 2: Merge overlapping intervals
        # Create a copy to avoid modifying the original
        merged_start = newInterval[0]
        merged_end = newInterval[1]
        
        while i < n and intervals[i][0] <= merged_end:
            merged_start = min(merged_start, intervals[i][0])
            merged_end = max(merged_end, intervals[i][1])
            i += 1

        # Add the merged interval
        result.append([merged_start, merged_end])
        
        # Phase 3: Add all remaining intervals
        while i < n:
            result.append(intervals[i])
            i += 1
        
        return result    