(fn [a]
  (= a (reduce + (filter #(zero? (mod a %)) (range 1 a)))))
