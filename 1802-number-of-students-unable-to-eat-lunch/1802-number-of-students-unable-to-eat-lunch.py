from collections import Counter
class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        #Assumption is that, we need someone who likes circular sandwich to take it from the top of the stack, only then the students who like square sandwiches can pick those up, else no students eat
        #So we need to keep a track of the students preferences count
        student_prefernces_count=Counter(students)

        for sandwich in sandwiches:
            if student_prefernces_count[sandwich]>0:
                student_prefernces_count[sandwich]-=1
            else:
                break
        return sum(student_prefernces_count.values())