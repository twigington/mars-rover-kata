(ns mars-rover-kata.core-test
  (:require [clojure.test :refer :all]
            [mars-rover-kata.core :refer :all]))

(deftest forward-north
  (testing "Move forward while facing north"
    (is (= {:x 0 :y 1 :r :north} (forward {:x 0 :y 0 :r :north})))))

(deftest forward-south
  (testing "Move forward while facing south"
    (is (= {:x 1 :y 0 :r :south} (forward {:x 1 :y 1 :r :south})))))

(deftest forward-east
  (testing "Move forward while facing east"
    (is (= {:x 2 :y 1 :r :east} (forward {:x 1 :y 1 :r :east})))))

(deftest forward-west
  (testing "Move forward while facing west"
    (is (= {:x 0 :y 1 :r :west} (forward {:x 1 :y 1 :r :west})))))

(deftest backward-north
  (testing "Move backward while facing north"
    (is (= {:x 1 :y 0 :r :north} (backward {:x 1 :y 1 :r :north})))))

(deftest backward-south
  (testing "Move backward while facing south"
    (is (= {:x 1 :y 2 :r :south} (backward {:x 1 :y 1 :r :south})))))

(deftest backward-east
  (testing "Move backward while facing east"
    (is (= {:x 0 :y 1 :r :east} (backward {:x 1 :y 1 :r :east})))))

(deftest backward-west
  (testing "Move backward while facing west"
    (is (= {:x 2 :y 1 :r :west} (backward {:x 1 :y 1 :r :west})))))

(deftest no-moves
  (testing "When no moves are provided, return the original position and direction."
    (is (= {:x 0 :y 0 :r :north} (move-rover {:x 0 :y 0 :r :north} [])))))

(deftest one-forward
  (testing "Move Forward Once."
    (is (= {:x 0 :y 1 :r :north} (move-rover {:x 0 :y 0 :r :north} [:forward])))))
