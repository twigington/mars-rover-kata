(ns mars-rover-kata.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn forward
  "Move forward to new position"
  [{x :x y :y r :r}]
  (case r
    :north {:x x :y (inc y) :r r}
    :south {:x x :y (dec y) :r r}
    :east {:x (inc x) :y y :r r}
    :west {:x (dec x) :y y :r r}
    :else {x :x y :y r :r}))

(defn backward
  "Move backward to new position"
  [{x :x y :y r :r}]
  (case r
    :north {:x x :y (dec y) :r r}
    :south {:x x :y (inc y) :r r}
    :east {:x (dec x) :y y :r r}
    :west {:x (inc x) :y y :r r}
    :else {x :x y :y r :r}))

(defn right
  [{x :x y :y r :r}]
  (case r
    :north {:x x :y y :r :east}
    :south {:x x :y y :r :west}
    :east {:x x :y y :r :south}
    :west {:x x :y y :r :north}
    :else {x :x y :y r :r}))
(defn left
  [{x :x y :y r :r}]
  (case r
    :north {:x x :y y :r :west}
    :south {:x x :y y :r :east}
    :east {:x x :y y :r :north}
    :west {:x x :y y :r :south}
    :else {x :x y :y r :r}))

(defn move-it
  [start-vector movement]
  (case movement
    :f (forward start-vector)
    :b (backward start-vector)
    :r (right start-vector)
    :l (left start-vector)))

(defn move-rover
  "Yarg"
  ([start-vector]
   start-vector)
  ([start-vector movements]
   (if (empty? movements)
     start-vector
     (reduce move-it start-vector movements)))
  ([start-vector movements obstacles]
   start-vector))