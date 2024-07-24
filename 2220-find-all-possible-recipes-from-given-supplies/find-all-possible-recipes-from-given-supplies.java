class Solution {
    public List<String> findAllRecipes(final String[] recipes, final List<List<String>> ingredients, final String[] supplies) {
        final Map<String, Integer> foodMap = new HashMap<>();
        final List<Pair<String, Boolean>> foodList = new ArrayList<>();

        int idx = 0;

        for(final String recipe : recipes) {
            if(!foodMap.containsKey(recipe)) {
                foodMap.put(recipe, idx++);
                foodList.add(new Pair<>(recipe, true));
            }
        }

        for(final List<String> list : ingredients) {
            for(final String ingredient : list) {
                if(!foodMap.containsKey(ingredient)) {
                    foodMap.put(ingredient, idx++);
                    foodList.add(new Pair<>(ingredient, false));
                }
            }
        }

        final Map<Integer, List<Integer>> graph = new HashMap<>();
        final int[] dependencies = new int[foodList.size()];

        for(int i = 0; i < ingredients.size(); ++i) {
            for(final String ingredient : ingredients.get(i)) {
                graph.putIfAbsent(foodMap.get(ingredient), new ArrayList<>());
                graph.get(foodMap.get(ingredient)).add(foodMap.get(recipes[i]));
                dependencies[foodMap.get(recipes[i])]++;
            }
        }

        final Queue<Integer> queue = new LinkedList<>();
        final List<String> result = new ArrayList<>();

        for(final String supply : supplies) {
            if(foodMap.containsKey(supply)) {
                idx = foodMap.get(supply);
                queue.offer(idx);

                if(foodList.get(idx).getValue())
                    result.add(supply);
            }
        }

        while(!queue.isEmpty()) {
            idx = queue.poll();

            if(graph.containsKey(idx)) {
                for(final int i : graph.get(idx)) {
                    dependencies[i]--;

                    if(dependencies[i] == 0) {
                        queue.offer(i);

                        if(foodList.get(i).getValue())
                            result.add(foodList.get(i).getKey());
                    }
                }
            }
        }

        return result;
    }
}