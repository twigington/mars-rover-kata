(ns mars-rover-kata.core-test
  (:require [clojure.test :refer :all]
            [mars-rover-kata.core :refer :all]))

(deftest no-moves
  (testing "When no moves are provided, return the original position and direction."
    (is (= {:x 0 :y 0 :r :north} (move-rover {:x 0 :y 0 :r :north} [])))))

(deftest forward-once
  (testing "Move Forward Once."
    (is (= {:x 0 :y 1 :r :north} (move-rover {:x 0 :y 0 :r :north} [:f])))))

(deftest forward-twice
  (testing "Move Forward Twice."
    (is (= {:x 0 :y 2 :r :north} (move-rover {:x 0 :y 0 :r :north} [:f :f])))))

(deftest forward-backward
  (testing "Move forward and then backwards."
    (is (= {:x 0 :y 0 :r :north} (move-rover {:x 0 :y 0 :r :north} [:f :b])))))

(deftest forward-right-left-backward
  (testing "Move turn, and return"
    (is (= {:x 0 :y 0 :r :north} (move-rover {:x 0 :y 0 :r :north} [:f :r :l :b])))))

(deftest forward-right-forward-left
  (testing "Move up and right and reorient."
    (is (= {:x 6 :y 6 :r :north} (move-rover {:x 5 :y 5 :r :north} [:f :r :f :l])))))

(deftest forward-right-forward-right-backward
  (testing "Make 5 moves."
    (is (= {:x 6 :y 7 :r :south} (move-rover {:x 5 :y 5 :r :north} [:f :r :f :r :b])))))

(deftest kata-example
  (testing "Example from kata."
    (is (= {:x 2 :y 2 :r :east} (move-rover {:x 0 :y 0 :r :north} [:f :f :r :f :f])))))

(deftest wrapping-west
  (testing "Test wrapping around going west."
    (is (= {:x 0 :y 99 :r :west} (move-rover {:x 0 :y 0 :r :west} [:f] {:length 100 :width 100})))))
