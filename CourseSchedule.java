import java.util.*;

//Time and Space - O(V+E)
//V - vertices, E - Edges
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int countOfCoursesTaken = 0;

        for(int[] prerequisite : prerequisites) {
            int dependant = prerequisite[0];
            int prereq = prerequisite[1];

            inDegrees[dependant]++;

            if(!map.containsKey(prereq)) {
                map.put(prereq, new ArrayList<>());
            }
            map.get(prereq).add(dependant);
        }

        for(int i=0; i<numCourses; i++) {
            if(inDegrees[i] == 0) {
                q.add(i);
                countOfCoursesTaken++;
            }
        }

        while(!q.isEmpty()) {
            int course = q.poll();

            if(!map.containsKey(course)) {
                continue;
            }

            List<Integer> dependants = map.get(course);
            if(dependants.isEmpty()) {
                continue;
            }

            for(int dependant : dependants) {
                inDegrees[dependant]--;
                if(inDegrees[dependant] == 0) {
                    q.add(dependant);
                    countOfCoursesTaken++;
                }
            }
        }

        return countOfCoursesTaken == numCourses;
    }
}
