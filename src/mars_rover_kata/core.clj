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

(defn move-rover
  "Yarg"
  ([start-vector]
   start-vector)
  ([start-vector movements]
   (if (empty? movements)
     start-vector
     start-vector))
  ([start-vector movements obstacles]
   start-vector))