(ns mars-rover-kata.core-test
  (:require [clojure.test :refer :all]
            [mars-rover-kata.core :refer :all]))

(deftest forward-north
  (testing "Move forward while facing north"
    (is (= {:x 0 :y 1 :r :north} (forward {:x 0 :y 0 :r :north})))))

(deftest forward-south
  (testing "Move forward while facing south"
    (is (= {:x 1 :y 0 :r :south} (forward {:x 1 :y 1 :r :south})))))

(deftest no-moves
  (testing "When no moves are provided, return the original position and direction."
    (is (= {:x 0 :y 0 :r :north} (move-rover {:x 0 :y 0 :r :north} [])))))

(deftest one-forward
  (testing "Move Forward Once."
    (is (= {:x 0 :y 1 :r :north} (move-rover {:x 0 :y 0 :r :north} [:forward])))))
