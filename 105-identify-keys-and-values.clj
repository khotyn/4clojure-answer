(fn [coll]
  (letfn [(step [c]
            (if (> (count c) 1)
              (let [key-size (count (first c))]
                (if (= key-size 1)
                  (concat [(first (first c)) (vec (second c))] (step (drop 2 c)))
                  (concat [(first (first c)) []] (step (cons (rest (first c)) (rest c))))))))]
    (let [vec-result (step (partition-by keyword? coll))]
      (if (seq vec-result)
        (apply (partial assoc {}) vec-result)
        {}))))