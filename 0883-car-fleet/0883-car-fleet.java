import java.util.*;

class Solution {
    // public int carFleet(int target, int[] position, int[] speed) {
    //     if(position.length != speed.length){
    //         return 0;
    //     }

    //     int number_of_fleets = 0;
    //     Stack<Float> stack = new Stack<>();
    //     ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();

    //     // Create pairs of position and speed
    //     for (int i = 0; i < position.length; i++) {
    //         pairs.add(new Pair<>(position[i], speed[i]));
    //     }

    //     // Sort cars by their position in descending order
    //     pairs.sort((a, b) -> b.getKey() - a.getKey());

    //     for (Pair<Integer, Integer> item : pairs) {
    //         int curr_car_start_position = item.getKey();
    //         int curr_car_speed = item.getValue();
    //         float time_to_reach_target = (target - curr_car_start_position) / (float) curr_car_speed;

    //         // If the stack is not empty, check the top car's time
    //         if (!stack.isEmpty()) {
    //             // Check if the current car takes longer or equal time to reach the target
    //             // than the car at the top of the stack (i.e., it will catch up or stay behind)
    //             if (stack.peek() >= time_to_reach_target) {
    //                 continue; // Current car joins the existing fleet
    //             }
    //         }

    //         // If a new fleet is formed, increase fleet count
    //         number_of_fleets++;
    //         stack.push(time_to_reach_target); // Add the current car's time to the stack
    //     }

    //     return number_of_fleets;
    // }

        public int carFleet(int target, int[] position, int[] speed) {
        if(position.length != speed.length){
            return 0;
        }

        int number_of_fleets = 0;
        Stack<Float> stack = new Stack<>();
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();

        // Create pairs of position and speed
        for (int i = 0; i < position.length; i++) {
            pairs.add(new Pair<>(position[i], speed[i]));
        }

        // Sort cars by their position in descending order
        pairs.sort((a, b) -> b.getKey() - a.getKey());

        for (Pair<Integer, Integer> item : pairs) {
            int curr_car_start_position = item.getKey();
            int curr_car_speed = item.getValue();
            float time_to_reach_target = (target - curr_car_start_position) / (float) curr_car_speed;
            // add the distance taken directly
            stack.push(time_to_reach_target);
            // when more than 2 cars, chance of a fleet
            if (!stack.isEmpty() && stack.size()>1) {
                // if curr car takes lesser or same time to reach as the next car, then it is a part of the fleet
                //so we will remove current car, and keep the next car
                //curr means in behind position
                //next means ahead in the position
                //because faster cars behind have to join the fleet
                float curr_car_time_taken=stack.peek();
                float car_ahead_time_taken=stack.elementAt(stack.size()-2);
                if (curr_car_time_taken<=car_ahead_time_taken) {
                    stack.pop();
                }
            }
        }

        return stack.size();
    }
}
