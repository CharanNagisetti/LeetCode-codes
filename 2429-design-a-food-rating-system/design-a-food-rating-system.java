import java.util.*;

class FoodRatings {

    private HashMap<String, String> foodToCuisine;          // food -> cuisine
    private HashMap<String, Integer> foodToRating;          // food -> rating
    private HashMap<String, TreeSet<Food>> cuisineToFoods;  // cuisine -> sorted foods

    // Inner class to store food name + rating
    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        // Need equals and hashCode for TreeSet removal
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Food)) return false;
            Food f = (Food) o;
            return rating == f.rating && name.equals(f.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }

    // Comparator: higher rating first, then lexicographically smaller
    private Comparator<Food> comp = (a, b) -> {
        if (b.rating != a.rating) return b.rating - a.rating;
        return a.name.compareTo(b.name);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>(comp));
            cuisineToFoods.get(cuisine).add(new Food(food, rating));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        TreeSet<Food> set = cuisineToFoods.get(cuisine);
        set.remove(new Food(food, oldRating));     // remove old rating
        foodToRating.put(food, newRating);         // update rating
        set.add(new Food(food, newRating));        // insert new rating
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
