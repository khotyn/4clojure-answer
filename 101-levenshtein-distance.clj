(fn [a b]
  (letfn [(step [calculated-result coordinate]
            (let [x (first coordinate)
                  y (last coordinate)]
              (assoc calculated-result
                coordinate
                (if (zero? (min x y))
                  (max x y)
                  (min
                    (inc (calculated-result [(dec x) y]))
                    (inc (calculated-result [x (dec y)]))
                    (+
                      (calculated-result [(dec x) (dec y)])
                      (if (= ((vec a) (dec x)) ((vec b) (dec y))) 0 1)))))))]
    ((reduce step {} (apply concat (map #(map (fn [i] [% i]) (range 0 (inc (count b)))) (range 0 (inc (count a)))))) [(count a) (count b)])))